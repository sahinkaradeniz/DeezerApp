package com.example.deezerapp.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.onError
import com.example.common.onSuccess
import com.example.deezerapp.core.UiState
import com.example.domain.entity.FavoritesEntity
import com.example.domain.usecase.deleteSongFavorites.DeleteSongFavoritesUseCase
import com.example.domain.usecase.getAllFavoriteSongs.GetAllFavoriteSongsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getAllFavoriteSongsUseCase: GetAllFavoriteSongsUseCase,
    private val deleteSongFavoritesUseCase: DeleteSongFavoritesUseCase,
) : ViewModel() {
    private val _favoriteUiState = MutableLiveData<UiState<List<FavoritesEntity>>>()
    val favoriteUiState: LiveData<UiState<List<FavoritesEntity>>> get() = _favoriteUiState
    private val _deleteFavoriteUiState = MutableLiveData<UiState<FavoritesEntity>>()
    val deleteFavoriteUiState: LiveData<UiState<FavoritesEntity>> get() = _deleteFavoriteUiState
    fun getAllFavoriteTracks() {
        viewModelScope.launch {
            getAllFavoriteSongsUseCase.invoke().onError {
                _favoriteUiState.postValue(UiState.Error(it?.error?.errorMessage.toString()))
            }.onSuccess {
                it?.let { list ->
                    _favoriteUiState.postValue(UiState.Success(list))
                }
            }
        }
    }

    fun deleteTrackFavorites(favoritesEntity: FavoritesEntity) {
        viewModelScope.launch {
            _deleteFavoriteUiState.postValue(UiState.Loading)
            deleteSongFavoritesUseCase.invoke(favoritesEntity).onSuccess {
                _deleteFavoriteUiState.postValue(UiState.Success(it))
                getAllFavoriteTracks()
            }.onError {
                _deleteFavoriteUiState.postValue(UiState.Error(it?.error?.errorMessage.toString()))
            }
        }
    }
}