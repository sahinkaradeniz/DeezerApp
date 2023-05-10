package com.example.data.api

import com.example.data.dto.artist_albums.ArtistAlbumsResponse
import com.example.data.dto.artist.ArtistResponse
import com.example.data.dto.genre_artists.GenreArtistsResponse
import com.example.data.dto.genre.MusicGenreResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DeezerApi {
    @GET("genre")
    suspend fun getGenresOfMusic(): MusicGenreResponse

    @GET("genre/{genre_id}/artists")
    suspend fun getGenreArtistsWithGenreId(
        @Path("genre_id") genre_id: Int,
    ): GenreArtistsResponse

    @GET("artist/{artist_id}")
    suspend fun getArtistWithArtistId(
        @Path("artist_id")  artist_id:Int
    ):ArtistResponse

    @GET("artist/{artist_id}/albums")
    suspend fun getArtistAlbumsWithArtistId(
        @Path("artist_id") artist_id: Int
    ):ArtistAlbumsResponse

}