package com.example.data.api

import com.example.data.dto.artists.MusicArtistsResponse
import com.example.data.dto.genre.MusicGenreResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DeezerApi {
    @GET("genre")
    suspend fun getGenresOfMusic(): MusicGenreResponse

    @GET("genre/{genre_id}/artists")
    suspend fun getGenreArtistsWithGenreId(
        @Path("genre_id") genre_id: Int,
    ): MusicArtistsResponse
}