package com.example.data.dto.genre_artists

import com.google.gson.annotations.SerializedName

data class GenreArtistsResponse (
    @SerializedName("data" ) var data : ArrayList<GenreArtistsData>

)