package com.example.data.dto.album_tracks

import com.google.gson.annotations.SerializedName

data class Artist (
    @SerializedName("id"        ) var id        : Int,
    @SerializedName("name"      ) var name      : String,
    @SerializedName("tracklist" ) var tracklist : String,
    @SerializedName("type"      ) var type      : String

)