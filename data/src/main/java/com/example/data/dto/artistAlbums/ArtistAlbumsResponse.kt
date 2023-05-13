package com.example.data.dto.artistAlbums

import com.google.gson.annotations.SerializedName

data class ArtistAlbumsResponse (
        @SerializedName("data"  ) var data  : List<ArtistAlbumsData> = arrayListOf(),
        @SerializedName("total" ) var total : Int?            = null
        )