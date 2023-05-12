package com.example.deezerapp.ui.albumTracks

import com.example.domain.entity.FavoritesEntity

data class TracksUiData(
    var id: Int,
    var title: String,
    var duration: Int,
    var preview: String,
    var artist: String,
    var picture:String="",
    var isFavorite:Boolean=false
)
