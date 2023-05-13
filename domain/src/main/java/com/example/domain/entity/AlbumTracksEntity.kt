package com.example.domain.entity

data class AlbumTracksEntity(
    var id: Int,
    var title: String,
    var duration: Int,
    var preview: String,
    var type: String,
    var artist: String,
)