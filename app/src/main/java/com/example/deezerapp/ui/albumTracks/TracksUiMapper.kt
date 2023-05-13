package com.example.deezerapp.ui.albumTracks

import com.example.common.mapper.DeezerListMapper
import com.example.domain.entity.AlbumTracksEntity
import com.example.domain.entity.FavoritesEntity
import javax.inject.Inject

class TracksUiMapper @Inject constructor(
) : DeezerListMapper<AlbumTracksEntity, TracksUiData> {
    override fun map(input: List<AlbumTracksEntity>): List<TracksUiData> {
        return input.map { track ->
            TracksUiData(
                id = track.id,
                duration = track.duration,
                title = track.title,
                preview = track.preview,
                artist = track.artist
            )
        }
    }

    fun mapWithFavorites(input: List<AlbumTracksEntity>, favoritesList: List<FavoritesEntity>): List<TracksUiData> {
        return input.map { track ->
            val isFavorite = favoritesList.any { favorite -> favorite.id == track.id }
            TracksUiData(
                id = track.id,
                duration = track.duration,
                title = track.title,
                preview = track.preview,
                artist = track.artist,
                isFavorite = isFavorite
            )
        }
    }
}
