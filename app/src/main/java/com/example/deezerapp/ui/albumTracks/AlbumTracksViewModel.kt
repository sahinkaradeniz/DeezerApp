package com.example.deezerapp.ui.albumTracks

import android.app.Application
import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common.onError
import com.example.common.onSuccess
import com.example.deezerapp.core.UiState
import com.example.deezerapp.util.toFavoriteEntity
import com.example.domain.entity.FavoritesEntity
import com.example.domain.usecase.addSongToFavorites.AddSongToFavoritesUseCase
import com.example.domain.usecase.deleteSongFavorites.DeleteSongFavoritesUseCase
import com.example.domain.usecase.getAlbumTracksWithAlbumId.GetAlbumTracksWithAlbumIdUseCase
import com.example.domain.usecase.getAllFavoriteSongs.GetAllFavoriteSongsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AlbumTracksViewModel @Inject constructor(
    private val getAlbumTracksWithAlbumIdUseCase: GetAlbumTracksWithAlbumIdUseCase,
    private val getAllFavoriteSongsUseCase: GetAllFavoriteSongsUseCase,
    private val addSongToFavoritesUseCase: AddSongToFavoritesUseCase,
    private val deleteSongFavoritesUseCase: DeleteSongFavoritesUseCase,
    private val tracksUiMapper: TracksUiMapper,
    application: Application,
) : AndroidViewModel(application) {
    private val tag = this.javaClass.simpleName
    private val _tracksUiState = MutableLiveData<UiState<List<TracksUiData>>>()
    val tracksUiState: LiveData<UiState<List<TracksUiData>>> get() = _tracksUiState
    private val _favoriteUiState= Channel<UiState<String>>()
    val favoriteUiState:Flow<UiState<String>> get() = _favoriteUiState.receiveAsFlow()

    private var favoritesList = listOf<FavoritesEntity>()


    fun getAlbumTracksWithAlbumId(albumId: Int) {
        viewModelScope.launch {
            _tracksUiState.postValue(UiState.Loading)
            getAllFavoriteTracks()
            getAlbumTracksWithAlbumIdUseCase.invoke(albumId).onError {
                _tracksUiState.postValue(UiState.Error(it?.error?.errorMessage.toString()))
            }.onSuccess {
                it?.let {list->
                    _tracksUiState.postValue(
                        UiState.Success(
                            tracksUiMapper.mapWithFavorites(
                                list,
                                favoritesList
                            )
                        )
                    )
                }
            }
        }
    }

    fun changeIsFavorite(tracksUiData: TracksUiData) {
        if (tracksUiData.isFavorite) {
            addFavoriteTrack(tracksUiData.toFavoriteEntity())
        } else {
            deleteFavoriteTrack(tracksUiData.toFavoriteEntity())
        }
        _tracksUiState.value = _tracksUiState.value
    }

    private suspend fun getAllFavoriteTracks() {
        getAllFavoriteSongsUseCase.invoke().onSuccess {
            favoritesList = it ?: listOf()
        }.onError {
            Log.e(tag, "error getAllFavoriteTracks: $it")
        }
    }

    private fun addFavoriteTrack(favoritesEntity: FavoritesEntity) {
        viewModelScope.launch {
            _favoriteUiState.send(UiState.Loading)
            addSongToFavoritesUseCase.invoke(favoritesEntity).onError {
                _favoriteUiState.send(UiState.Error(it?.error?.errorMessage.toString()))
            }.onSuccess {
                _favoriteUiState.send(UiState.Success("Added to Favorites"))
            }
        }
    }

    private fun deleteFavoriteTrack(favoritesEntity: FavoritesEntity) {
        viewModelScope.launch {
            _favoriteUiState.send(UiState.Loading)
            deleteSongFavoritesUseCase.invoke(favoritesEntity).onError {
                _favoriteUiState.send(UiState.Error(it?.error?.errorMessage.toString()))
            }.onSuccess {
                _favoriteUiState.send(UiState.Success("Removed to Favorites"))
            }
        }
    }

}
