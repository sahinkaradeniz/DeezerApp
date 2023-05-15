package com.example.deezerapp.ui.genres

import com.example.deezerapp.core.UiData

data class GenresUiData(
    override var id: Int,
    var name: String,
    var picture: String,
): UiData()