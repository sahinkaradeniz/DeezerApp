package com.example.data.source.remote

import com.example.common.ResponseResult
import com.example.common.ResultError
import com.example.data.datastore.api.DeezerApi
import com.example.data.dto.albumTracks.AlbumTracksData
import com.example.data.dto.artist.ArtistResponse
import com.example.data.dto.artistAlbums.ArtistAlbumsData
import com.example.data.dto.genre.MusicGenreData
import com.example.data.dto.genreArtists.GenreArtistsData
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


/**
 * RemoteDataSourceImpl is the implementation of the remote data source.
 * It performs API requests to retrieve data from the Deezer API.
 */
class RemoteDataSourceImpl @Inject constructor(
    private val deezerApi: DeezerApi,
) : RemoteDataSource {
    /**
     * Retrieves all genres of music.
     *
     * @return A ResponseResult containing a list of MusicGenreData.
     */
    override suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreData>> {
        return try {
            val response = deezerApi.getGenresOfMusic()
            ResponseResult.Success(response.data)
        } catch (e: IOException) {
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        } catch (e: HttpException) {
            ResponseResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    /**
     * Retrieves genre artists with the given genre ID.
     *
     * @param genreId The ID of the genre.
     * @return A ResponseResult containing a list of GenreArtistsData.
     */
    override suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsData>> {
        return try {
            val response = deezerApi.getGenreArtistsWithGenreId(genreId)
            ResponseResult.Success(response.data)
        } catch (e: IOException) {
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        } catch (e: HttpException) {
            ResponseResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    /**
     * Retrieves genre artists with the given genre ID.
     *
     * @param genreId The ID of the genre.
     * @return A ResponseResult containing a list of GenreArtistsData.
     */
    override suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistResponse> {
        return try {
            val response = deezerApi.getArtistWithArtistId(artistId)
            ResponseResult.Success(response)
        } catch (e: IOException) {
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        } catch (e: HttpException) {
            ResponseResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    /**
     * Retrieves artist albums with the given artist ID.
     *
     * @param artistId The ID of the artist.
     * @return A ResponseResult containing a list of ArtistAlbumsData.
     */
    override suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsData>> {
        return try {
            val response = deezerApi.getArtistAlbumsWithArtistId(artistId)
            ResponseResult.Success(response.data)
        } catch (e: IOException) {
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        } catch (e: HttpException) {
            ResponseResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    /**
     * Retrieves album tracks with the given album ID.
     *
     * @param albumId The ID of the album.
     * @return A ResponseResult containing a list of AlbumTracksData.
     */
    override suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksData>> {
        return try {
            val response = deezerApi.getAlbumTracksWithAlbumId(albumId)
            ResponseResult.Success(response.data)
        } catch (e: IOException) {
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        } catch (e: HttpException) {
            ResponseResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }
}