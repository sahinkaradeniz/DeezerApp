package com.example.data.dto.album

import com.google.gson.annotations.SerializedName

data class ArtistAlbumsResponse (
        @SerializedName("data"  ) var data  : ArrayList<ArtistAlbumsData> = arrayListOf(),
        @SerializedName("total" ) var total : Int?            = null
        )