package com.example.data.dto.genre

import com.google.gson.annotations.SerializedName

data class MusicGenreResponse(
    @SerializedName("data") var data: List<MusicGenreData>,
)