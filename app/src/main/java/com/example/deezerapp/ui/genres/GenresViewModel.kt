package com.example.deezerapp.ui.genres

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
    private val _genresUiState = MutableLiveData<UiState<List<GenresUiData>>>()
    val genresUiState: LiveData<UiState<List<GenresUiData>>> get() = _genresUiState
    fun getAllGenresOfMusic() {
        viewModelScope.launch {
            if (genresUiState.value == null) {
                _genresUiState.postValue(UiState.Loading)
                getAllGenresOfMusicUseCase.invoke()
                    .onError {
                        _genresUiState.postValue(UiState.Error(it?.error?.errorMessage.toString()))
                    }.onSuccess {
                        it?.let { list ->
                            _genresUiState.postValue(UiState.Success(genresUiMapper.map(list)))
                        }
                    }
            }
        }
    }
}