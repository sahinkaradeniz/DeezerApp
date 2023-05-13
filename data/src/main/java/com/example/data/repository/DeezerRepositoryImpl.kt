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

/**
 * DeezerRepositoryImpl is the implementation of the DeezerRepository interface.
 * It handles the communication between the data sources and the domain layer.
 */
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
    /**
     * Adds a song to the favorites.
     *
     * @param favoritesEntity The FavoritesEntity representing the song to be added.
     * @return A ResponseResult containing the added FavoritesEntity.
     */
    override suspend fun addSongToFavorites(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity> {
        return withContext(ioDispatcher) {
            val result =
                localDataSource.addSongToFavorites(favoriteMapperEtoDb.map(favoritesEntity))
            result.toDomain(favoriteMapperDbtoE)
        }
    }

    /**
     * Retrieves all favorite songs.
     *
     * @return A ResponseResult containing a list of FavoritesEntity.
     */
    override suspend fun getAllFavoriteSongs(): ResponseResult<List<FavoritesEntity>> {
        return withContext(ioDispatcher) {
            val result = localDataSource.getAllFavoriteSongs()
            result.toDomain(favoritesListMapper)
        }
    }

    /**
     * Deletes a song from the favorites.
     *
     * @param favoritesEntity The FavoritesEntity representing the song to be deleted.
     * @return A ResponseResult containing the deleted FavoritesEntity.
     */
    override suspend fun deleteSongToFavorites(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity> {
        return withContext(ioDispatcher) {
            val result =
                localDataSource.deleteSongToFavorites(favoriteMapperEtoDb.map(favoritesEntity))
            result.toDomain(favoriteMapperDbtoE)
        }
    }

    /**
     * Retrieves a favorite song with a specific ID.
     *
     * @param id The ID of the favorite song to be retrieved.
     * @return A ResponseResult containing the retrieved FavoritesEntity.
     */
    override suspend fun getFavoriteSongWithId(id: Int): ResponseResult<FavoritesEntity> {
        return withContext(ioDispatcher) {
            val result = localDataSource.getFavoriteSongWithId(id)
            result.toDomain(favoriteMapperDbtoE)
        }
    }

    /**
     * Retrieves all genres of music.
     *
     * @return A ResponseResult containing a list of MusicGenreEntity.
     */
    override suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreEntity>> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getAllGenresOfMusic()
            response.toDomain(musicGenreListMapper)
        }
    }

    /**
     * Retrieves the list of artists belonging to a specific genre.
     *
     * @param genreId The ID of the genre.
     * @return A ResponseResult containing a list of GenreArtistsEntity.
     */
    override suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsEntity>> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getGenreArtistsWithGenreId(genreId)
            response.toDomain(genreArtistListMapper)
        }
    }

    /**
     * Retrieves the details of an artist with a specific ID.
     *
     * @param artistId The ID of the artist.
     * @return A ResponseResult containing the ArtistEntity.
     */
    override suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistEntity> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getArtistWithArtistId(artistId)
            response.toDomain(artistMapper)
        }
    }

    /**
     * Retrieves the albums of an artist with a specific ID.
     *
     * @param artistId The ID of the artist.
     * @return A ResponseResult containing a list of ArtistAlbumsEntity.
     */
    override suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsEntity>> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getArtistAlbumsWithArtistId(artistId)
            response.toDomain(artistAlbumsListMapper)
        }
    }

    /**
     * Retrieves the tracks of an album with a specific ID.
     *
     * @param albumId The ID of the album.
     * @return A ResponseResult containing a list of AlbumTracksEntity.
     */
    override suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksEntity>> {
        return withContext(ioDispatcher) {
            val response = remoteDataSource.getAlbumTracksWithAlbumId(albumId)
            response.toDomain(albumTracksListMapper)
        }
    }
}