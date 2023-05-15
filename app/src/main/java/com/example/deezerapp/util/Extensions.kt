package com.example.deezerapp.util

import com.example.deezerapp.ui.albumTracks.TracksUiData
import com.example.deezerapp.ui.favorite.FavoriteUiData
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
fun FavoritesEntity.toFavoriteUiData():FavoriteUiData{
    return FavoriteUiData(
        id=this.id,
        title=this.title,
        duration=this.duration,
        artistName = this.artistName,
        picture = this.picture
    )
}
fun FavoriteUiData.toFavoriteEntity():FavoritesEntity{
    return FavoritesEntity(
        id=this.id,
        title=this.title,
        duration=this.duration,
        artistName = this.artistName,
        picture = this.picture
    )

}