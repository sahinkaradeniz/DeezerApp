package com.example.data.source.remote

import com.example.common.ResponseResult
import com.example.data.dto.album_tracks.AlbumTracksData
import com.example.data.dto.artist.ArtistResponse
import com.example.data.dto.artist_albums.ArtistAlbumsData
import com.example.data.dto.genre.MusicGenreData
import com.example.data.dto.genre_artists.GenreArtistsData

interface RemoteDataSource {
    suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreData>>

    suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsData>>

    suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistResponse>

    suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsData>>

    suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksData>>
}