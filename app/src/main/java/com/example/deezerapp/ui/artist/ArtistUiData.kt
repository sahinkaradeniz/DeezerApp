package com.example.deezerapp.ui.artist

data class ArtistUiData(
    var id: Int,
    var name: String,
    var picture: String,
    var albums:List<AlbumsUiData>
)
