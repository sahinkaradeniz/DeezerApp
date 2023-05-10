package com.example.data.dto.artist_albums

import com.google.gson.annotations.SerializedName

data class ArtistAlbumsResponse (
        @SerializedName("data"  ) var data  : ArrayList<ArtistAlbumsData> = arrayListOf(),
        @SerializedName("total" ) var total : Int?            = null
        )