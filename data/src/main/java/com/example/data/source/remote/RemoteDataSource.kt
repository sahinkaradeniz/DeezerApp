package com.example.data.source.remote

import com.example.common.ResponseResult
import com.example.data.dto.albumTracks.AlbumTracksData
import com.example.data.dto.artist.ArtistResponse
import com.example.data.dto.artistAlbums.ArtistAlbumsData
import com.example.data.dto.genre.MusicGenreData
import com.example.data.dto.genreArtists.GenreArtistsData

/**
 * RemoteDataSource is the interface for the remote data source.
 * It defines methods to perform API requests for retrieving data from the Deezer API.
 */
interface RemoteDataSource {
    /**
     * Retrieves all genres of music.
     *
     * @return A ResponseResult containing a list of MusicGenreData.
     */
    suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreData>>

    /**
     * Retrieves genre artists with the given genre ID.
     *
     * @param genreId The ID of the genre.
     * @return A ResponseResult containing a list of GenreArtistsData.
     */
    suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsData>>

    /**
     * Retrieves an artist with the given artist ID.
     *
     * @param artistId The ID of the artist.
     * @return A ResponseResult containing an ArtistResponse.
     */
    suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistResponse>

    /**
     * Retrieves artist albums with the given artist ID.
     *
     * @param artistId The ID of the artist.
     * @return A ResponseResult containing a list of ArtistAlbumsData.
     */
    suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsData>>

    /**
     * Retrieves album tracks with the given album ID.
     *
     * @param albumId The ID of the album.
     * @return A ResponseResult containing a list of AlbumTracksData.
     */
    suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksData>>
}
