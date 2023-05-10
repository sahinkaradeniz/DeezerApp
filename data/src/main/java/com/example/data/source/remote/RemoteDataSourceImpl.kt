package com.example.data.source.remote

import com.example.common.ResponseResult
import com.example.common.ResultError
import com.example.data.datastore.api.DeezerApi
import com.example.data.dto.album_tracks.AlbumTracksData
import com.example.data.dto.artist.ArtistResponse
import com.example.data.dto.artist_albums.ArtistAlbumsData
import com.example.data.dto.genre.MusicGenreData
import com.example.data.dto.genre_artists.GenreArtistsData
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val deezerApi: DeezerApi
):RemoteDataSource {
    override suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreData>> {
        return try {
            val response =deezerApi.getGenresOfMusic()
            ResponseResult.Success(response.data)
        }catch (e:IOException){
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }catch (e:HttpException){
            ResponseResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    override suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsData>> {
        return try {
            val response =deezerApi.getGenreArtistsWithGenreId(genreId)
            ResponseResult.Success(response.data)
        }catch (e:IOException){
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }catch (e:HttpException){
            ResponseResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    override suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistResponse> {
        return try {
            val response =deezerApi.getArtistWithArtistId(artistId)
            ResponseResult.Success(response)
        }catch (e:IOException){
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }catch (e:HttpException){
            ResponseResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    override suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsData>> {
        return try {
            val response =deezerApi.getArtistAlbumsWithArtistId(artistId)
            ResponseResult.Success(response.data)
        }catch (e:IOException){
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }catch (e:HttpException){
            ResponseResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    override suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksData>> {
        return try {
            val response =deezerApi.getAlbumTracksWithAlbumId(albumId)
            ResponseResult.Success(response.data)
        }catch (e:IOException){
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }catch (e:HttpException){
            ResponseResult.Error.ApiError(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }
}