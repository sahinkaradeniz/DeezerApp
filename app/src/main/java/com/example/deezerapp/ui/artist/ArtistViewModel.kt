package com.example.deezerapp.ui.artist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.onError
import com.example.common.onSuccess
import com.example.deezerapp.core.UiState
import com.example.domain.usecase.getArtistAlbumsWithArtistId.GetArtistAlbumsWithArtistIdUseCase
import com.example.domain.usecase.getArtistWithArtistId.GetArtistWithArtistIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistViewModel @Inject constructor(
    private val getArtistAlbumsWithArtistIdUseCase: GetArtistAlbumsWithArtistIdUseCase,
    private val getArtistWithArtistIdUseCase: GetArtistWithArtistIdUseCase,
    private val albumsUiMapper: AlbumsUiMapper,
    private val artistUiMapper: ArtistUiMapper,
) : ViewModel() {
    private val _artistUiState = MutableLiveData<UiState<ArtistUiData>>()
    val artistUiState: LiveData<UiState<ArtistUiData>> get() = _artistUiState
    private var artistData:ArtistUiData?=null

    fun fetchArtistData(artistId: Int) {
        viewModelScope.launch {
            if (artistData==null){
                _artistUiState.postValue(UiState.Loading)
                getArtistWithArtistId(artistId)
                getArtistAlbumsWithArtistId(artistId)
            }
        }
    }

    private suspend fun getArtistWithArtistId(artistId: Int) {
        getArtistWithArtistIdUseCase.invoke(artistId).onSuccess {
            it?.let {
                artistData = artistUiMapper.map(it)
                _artistUiState.postValue(UiState.Success(artistData))
            }
        }.onError {
            _artistUiState.postValue(UiState.Error(it?.error.toString()))
        }
    }

    private suspend fun getArtistAlbumsWithArtistId(artistId: Int) {
        getArtistAlbumsWithArtistIdUseCase.invoke(artistId).onSuccess {
            it?.let {
                artistData?.albums = albumsUiMapper.map(it)
                _artistUiState.postValue(UiState.Success(artistData))
            }
        }.onError {
            _artistUiState.postValue(UiState.Error(it?.error.toString()))
        }
    }
}