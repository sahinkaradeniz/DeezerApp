package com.example.data.dto.artists

import com.google.gson.annotations.SerializedName

data class MusicArtistsResponse (
    @SerializedName("data" ) var data : ArrayList<MusicArtistsData>

)