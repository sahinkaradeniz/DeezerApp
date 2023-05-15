package com.example.deezerapp.ui.albumTracks

import com.example.deezerapp.core.UiData

data class TracksUiData(
    override var id: Int,
    var title: String,
    var duration: Int,
    var preview: String,
    var artist: String,
    var picture:String="",
    var isFavorite:Boolean=false
): UiData()
