package com.example.deezerapp.ui.genreArtists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.onError
import com.example.common.onSuccess
import com.example.deezerapp.core.UiState
import com.example.domain.usecase.getGenreArtistsWithGenreId.GetGenreArtistsWithGenreIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GenreArtistsViewModel @Inject constructor(
    private val getGenreArtistsWithGenreIdUseCase: GetGenreArtistsWithGenreIdUseCase,
    private val genreArtistsUiMapper: GenreArtistsUiMapper,
) : ViewModel() {
    private val _genreArtistsUiState = MutableLiveData<UiState<List<GenreArtistsUiData>>>()
    val genreArtistsUiState: LiveData<UiState<List<GenreArtistsUiData>>> get() = _genreArtistsUiState
    fun getGenreArtistsWithGenreId(genreId: Int) {
        viewModelScope.launch {
            if (genreArtistsUiState.value == null) {
                _genreArtistsUiState.postValue(UiState.Loading)
                getGenreArtistsWithGenreIdUseCase.invoke(genreId)
                    .onError {
                        _genreArtistsUiState.postValue(UiState.Loading)
                    }.onSuccess {
                        it?.let { list ->
                            _genreArtistsUiState.postValue(
                                UiState.Success(
                                    genreArtistsUiMapper.map(
                                        list
                                    )
                                )
                            )
                        }
                    }
            }
        }
    }
}