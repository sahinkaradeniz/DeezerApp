package com.example.deezerapp.ui.artist

import com.example.deezerapp.core.UiData

data class ArtistUiData(
    override var id: Int,
    var name: String,
    var picture: String,
    var albums:List<AlbumsUiData>
):UiData()
