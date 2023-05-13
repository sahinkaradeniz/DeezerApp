package com.example.data.dto.genreArtists

import com.google.gson.annotations.SerializedName

data class GenreArtistsResponse (
    @SerializedName("data" ) var data : ArrayList<GenreArtistsData>

)