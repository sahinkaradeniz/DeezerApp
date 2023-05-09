package com.example.data.dto.artists

import com.google.gson.annotations.SerializedName
data class GenreArtistsData(
    @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("picture") var picture: String,
    @SerializedName("picture_small") var pictureSmall: String,
    @SerializedName("picture_medium") var pictureMedium: String,
    @SerializedName("picture_big") var pictureBig: String,
    @SerializedName("picture_xl") var pictureXl: String,
    @SerializedName("radio") var radio: Boolean,
    @SerializedName("tracklist") var tracklist: String,
    @SerializedName("type") var type: String,
)