package com.example.deezerapp.ui.genreArtists

import com.example.deezerapp.core.UiData

data class GenreArtistsUiData(
    override var id: Int,
    var name: String,
    var picture: String,
):UiData()