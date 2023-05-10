package com.example.data.source.remote

import com.example.common.ResponseResult
import com.example.data.dto.album_tracks.AlbumTracksData
import com.example.data.dto.artist.ArtistResponse
import com.example.data.dto.artist_albums.ArtistAlbumsData
import com.example.data.dto.genre.MusicGenreData
import com.example.data.dto.genre_artists.GenreArtistsData
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(

):RemoteDataSource {
    override suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreData>> {
        TODO("Not yet implemented")
    }

    override suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsData>> {
        TODO("Not yet implemented")
    }

    override suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsData>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksData>> {
        TODO("Not yet implemented")
    }
}