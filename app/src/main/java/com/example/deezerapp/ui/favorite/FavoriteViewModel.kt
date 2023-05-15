package com.example.deezerapp.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.onError
import com.example.common.onSuccess
import com.example.deezerapp.core.UiState
import com.example.deezerapp.util.toFavoriteEntity
import com.example.deezerapp.util.toFavoriteUiData
import com.example.domain.usecase.deleteSongFavorites.DeleteSongFavoritesUseCase
import com.example.domain.usecase.getAllFavoriteSongs.GetAllFavoriteSongsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getAllFavoriteSongsUseCase: GetAllFavoriteSongsUseCase,
    private val deleteSongFavoritesUseCase: DeleteSongFavoritesUseCase,
) : ViewModel() {
    private val _favoriteUiState = MutableLiveData<UiState<List<FavoriteUiData>>>()
    val favoriteUiState: LiveData<UiState<List<FavoriteUiData>>> get() = _favoriteUiState
    private val _deleteFavoriteUiState = Channel<UiState<String>>()
    val deleteFavoriteUiState: Flow<UiState<String>> get() = _deleteFavoriteUiState.receiveAsFlow()
    fun getAllFavoriteTracks() {
        viewModelScope.launch {
            getAllFavoriteSongsUseCase.invoke().onError {
                _favoriteUiState.postValue(UiState.Error(it?.error?.errorMessage.toString()))
            }.onSuccess {
                it?.let { list ->
                    _favoriteUiState.postValue(UiState.Success(list.map { entity-> entity.toFavoriteUiData() }))
                }
            }
        }
    }

    fun deleteTrackFavorites(favoriteUiData: FavoriteUiData) {
        viewModelScope.launch {
            _deleteFavoriteUiState.send(UiState.Loading)
            deleteSongFavoritesUseCase.invoke(favoriteUiData.toFavoriteEntity()).onSuccess {
                _deleteFavoriteUiState.send(UiState.Success(it?.title))
                getAllFavoriteTracks()
            }.onError {
                _deleteFavoriteUiState.send(UiState.Error(it?.error?.errorMessage.toString()))
            }
        }
    }
}