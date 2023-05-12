package com.example.deezerapp.ui.albumTracks

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.extension.formatDuration
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
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AlbumTracksViewModel @Inject constructor(
    private val getAlbumTracksWithAlbumIdUseCase: GetAlbumTracksWithAlbumIdUseCase,
    private val getAllFavoriteSongsUseCase: GetAllFavoriteSongsUseCase,
    private val addSongToFavoritesUseCase: AddSongToFavoritesUseCase,
    private val deleteSongFavoritesUseCase: DeleteSongFavoritesUseCase,
    private val tracksUiMapper: TracksUiMapper,
) : ViewModel() {
    private val className = this.javaClass.simpleName
    private val _tracksUiState = MutableLiveData<UiState<List<TracksUiData>>>()
    val tracksUiState: LiveData<UiState<List<TracksUiData>>> get() = _tracksUiState
    private val _favoriteState = MutableLiveData<UiState<String>>()
    val favoriteState: LiveData<UiState<String>> get() = _favoriteState
    private var favoritesList = listOf<FavoritesEntity>()

    private var mediaPlayer: MediaPlayer? = null
    private val _isPlaying = MutableLiveData<Boolean>()
    val isPlaying: LiveData<Boolean> get() = _isPlaying

    init {
        _isPlaying.value = false
    }
    fun getAlbumTracksWithAlbumId(albumId: Int) {
        viewModelScope.launch {
            _tracksUiState.postValue(UiState.Loading)
            getAllFavoriteTracks()
            getAlbumTracksWithAlbumIdUseCase.invoke(albumId).onError {
                _tracksUiState.postValue(UiState.Error(it?.error?.errorMessage.toString()))
            }.onSuccess {
                it?.let {
                    _tracksUiState.postValue(
                        UiState.Success(
                            tracksUiMapper.mapWithFavorites(
                                it,
                                favoritesList
                            )
                        )
                    )
                }
            }
        }
    }

    fun changeIsFavorite(tracksUiData: TracksUiData) {
        tracksUiData.isFavorite = !tracksUiData.isFavorite
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
            Log.e(className, "error getAllFavoriteTracks: $it")
        }
    }

    private fun addFavoriteTrack(favoritesEntity: FavoritesEntity) {
        viewModelScope.launch {
            _favoriteState.postValue(UiState.Loading)
            addSongToFavoritesUseCase.invoke(favoritesEntity).onError {
                _favoriteState.postValue(UiState.Error(it?.error?.errorMessage.toString()))
            }.onSuccess {
                _favoriteState.postValue(UiState.Success("Added to Favorites"))
            }
        }
    }

    private fun deleteFavoriteTrack(favoritesEntity: FavoritesEntity) {
        viewModelScope.launch {
            viewModelScope.launch {
                _favoriteState.postValue(UiState.Loading)
                deleteSongFavoritesUseCase.invoke(favoritesEntity).onError {
                    _favoriteState.postValue(UiState.Error(it?.error?.errorMessage.toString()))
                }.onSuccess {
                    _favoriteState.postValue(UiState.Success("Removed from favorites"))
                }
            }
        }
    }

    private fun stopPlayback() {
        mediaPlayer?.apply {
            stop()
            reset()
            release()
        }
        mediaPlayer = null
        _isPlaying.postValue(false)
    }

    fun startPlayback(context: Context, musicUrl: String) {
        stopPlayback()
        mediaPlayer = MediaPlayer().apply {
            setDataSource(context, Uri.parse(musicUrl))
            prepareAsync()
            setOnPreparedListener { player ->
                player.start()
                _isPlaying.postValue(true)
            }
            setOnCompletionListener {
                stopPlayback()
            }
        }
    }

    fun togglePlayback() {
        mediaPlayer?.let { player ->
            if (player.isPlaying) {
                player.pause()
                _isPlaying.postValue(false)
            } else {
                player.start()
                _isPlaying.postValue(true)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        stopPlayback()
    }
}
