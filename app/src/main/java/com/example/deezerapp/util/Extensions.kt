package com.example.deezerapp.util

import com.example.deezerapp.ui.albumTracks.TracksUiData
import com.example.domain.entity.FavoritesEntity

fun TracksUiData.toFavoriteEntity(): FavoritesEntity {
    return FavoritesEntity(
        id=this.id,
        title=this.title,
        duration=this.duration,
        artistName = this.artist,
        picture = this.picture
    )
}