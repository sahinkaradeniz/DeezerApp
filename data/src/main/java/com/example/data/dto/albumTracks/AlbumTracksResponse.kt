package com.example.data.dto.albumTracks

import com.google.gson.annotations.SerializedName

data class AlbumTracksResponse (
    @SerializedName("data"  ) var data  : List<AlbumTracksData> = arrayListOf(),
    @SerializedName("total" ) var total : Int?            = null,
    @SerializedName("next"  ) var next  : String?         = null
)