package com.example.data.repository

import com.example.common.ResponseResult
import com.example.data.di.coroutine.IoDispatcher
import com.example.data.mapper.*
import com.example.data.source.local.LocalDataSource
import com.example.data.source.remote.RemoteDataSource
import com.example.data.util.toDomain
import com.example.domain.entity.*
import com.example.domain.repository.DeezerRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeezerRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val favoriteMapperEtoDb: FavoriteMapperEtoDb,
    private val favoriteMapperDbtoE: FavoriteMapperDbtoE,
    private val favoritesListMapper: FavoritesListMapper,
    private val musicGenreListMapper: MusicGenreListMapper,
    private val genreArtistListMapper: GenreArtistListMapper,
    private val artistMapper: ArtistMapper,
    private val artistAlbumsListMapper: ArtistAlbumsListMapper,
    private val albumTracksListMapper: AlbumTracksListMapper,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) : DeezerRepository {
    override suspend fun addSongToFavorites(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity> {
        return withContext(ioDispatcher) {
            val result =
                localDataSource.addSongToFavorites(favoriteMapperEtoDb.map(favoritesEntity))
            result.toDomain(favoriteMapperDbtoE)
        }
    }


    override suspend fun getAllFavoriteSongs(): ResponseResult<List<FavoritesEntity>> {
        return withContext(ioDispatcher) {
            val result = localDataSource.getAllFavoriteSongs()
            result.toDomain(favoritesListMapper)
        }
    }

    override suspend fun deleteSongToFavorites(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity> {
        return withContext(ioDispatcher) {
            val result =
                localDataSource.deleteSongToFavorites(favoriteMapperEtoDb.map(favoritesEntity))
            result.toDomain(favoriteMapperDbtoE)
        }
    }

    override suspend fun getFavoriteSongWithId(id: Int): ResponseResult<FavoritesEntity> {
        return withContext(ioDispatcher) {
            val result = localDataSource.getFavoriteSongWithId(id)
            result.toDomain(favoriteMapperDbtoE)
        }
    }


    override suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreEntity>> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getAllGenresOfMusic()
            response.toDomain(musicGenreListMapper)
        }
    }

    override suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsEntity>> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getGenreArtistsWithGenreId(genreId)
            response.toDomain(genreArtistListMapper)
        }
    }

    override suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistEntity> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getArtistWithArtistId(artistId)
            response.toDomain(artistMapper)
        }
    }

    override suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsEntity>> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getArtistAlbumsWithArtistId(artistId)
            response.toDomain(artistAlbumsListMapper)
        }
    }

    override suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksEntity>> {
        return withContext(ioDispatcher){
            val response =remoteDataSource.getAlbumTracksWithAlbumId(albumId)
            response.toDomain(albumTracksListMapper)
        }
    }
}