package com.example.deezerapp.ui.favorite

import com.example.deezerapp.core.UiData

data class FavoriteUiData(
    override var id: Int,
    var title: String,
    var duration: Int,
    var artistName: String,
    var picture:String,
):UiData()