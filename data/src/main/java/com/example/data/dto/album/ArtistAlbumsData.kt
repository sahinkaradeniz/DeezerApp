package com.example.data.dto.album

import com.google.gson.annotations.SerializedName

data class ArtistAlbumsData(
        @SerializedName("id") var id: Int,
        @SerializedName("title") var title: String,
        @SerializedName("link") var link: String,
        @SerializedName("cover") var cover: String,
        @SerializedName("cover_small") var coverSmall: String,
        @SerializedName("cover_medium") var coverMedium: String,
        @SerializedName("cover_big") var coverBig: String,
        @SerializedName("cover_xl") var coverXl: String,
        @SerializedName("md5_image") var md5Image: String,
        @SerializedName("genre_id") var genreId: Int,
        @SerializedName("fans") var fans: Int,
        @SerializedName("release_date") var releaseDate: String,
        @SerializedName("record_type") var recordType: String,
        @SerializedName("tracklist") var tracklist: String,
        @SerializedName("explicit_lyrics") var explicitLyrics: Boolean,
        @SerializedName("type") var type: String,
)