package com.example.data.api

import com.example.data.dto.genre.MusicGenreResponse
import retrofit2.http.GET

interface DeezerApi {
    @GET("genre")
    suspend fun getGenresOfMusic():MusicGenreResponse
}