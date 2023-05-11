package com.example.deezerapp.ui.genres

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.onError
import com.example.common.onSuccess
import com.example.deezerapp.core.UiState
import com.example.domain.usecase.getAllGenresOfMusic.GetAllGenresOfMusicUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenresViewModel @Inject constructor(
    private val getAllGenresOfMusicUseCase: GetAllGenresOfMusicUseCase,
    private val genresUiMapper: GenresUiMapper,
) : ViewModel() {
    private val _genresList = MutableLiveData<UiState<List<GenresUiData>>>()
    val genresList: LiveData<UiState<List<GenresUiData>>> get() = _genresList
    fun getAllGenresOfMusic() {
        viewModelScope.launch {
            _genresList.postValue(UiState.Loading)
            getAllGenresOfMusicUseCase.invoke()
                .onError {
                    _genresList.postValue(UiState.Error(it?.error?.errorMessage.toString()))
                    Log.e("test ", "eror :  ${_genresList.value}", )
                }.onSuccess {
                    it?.let { list ->
                        _genresList.postValue(UiState.Success(genresUiMapper.map(list)))
                        Log.e("test ", "succes :  $list", )
                    }
                }
        }
    }
}