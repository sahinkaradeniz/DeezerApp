package com.example.data.dto.album_tracks

import com.google.gson.annotations.SerializedName

data class AlbumTracksResponse (
    @SerializedName("data"  ) var data  : ArrayList<AlbumTracksData> = arrayListOf(),
    @SerializedName("total" ) var total : Int?            = null,
    @SerializedName("next"  ) var next  : String?         = null
)