package com.example.data.dto.album_tracks

import com.google.gson.annotations.SerializedName

data class Artist (
    @SerializedName("id"        ) var id        : Int?    = null,
    @SerializedName("name"      ) var name      : String? = null,
    @SerializedName("tracklist" ) var tracklist : String? = null,
    @SerializedName("type"      ) var type      : String? = null

)