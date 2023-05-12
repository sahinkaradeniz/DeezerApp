package com.example.data.source.local

import com.example.common.ResponseResult
import com.example.common.ResultError
import com.example.data.datastore.room.FavoritesDao
import com.example.data.dto.favorite.FavoritesDbModel
import javax.inject.Inject

/**
 * LocalDataSourceImpl is the implementation of the local data source.
 * It performs operations related to favorite songs.
 */
class LocalDataSourceImpl @Inject constructor(
    private val favoritesDao: FavoritesDao,
) : LocalDataSource {
    /**
     * Adds a song to favorites.
     *
     * @param favoritesDbModel The FavoritesDbModel to be added.
     * @return A ResponseResult containing the added FavoritesDbModel.
     */
    override suspend fun addSongToFavorites(favoritesDbModel: FavoritesDbModel): ResponseResult<FavoritesDbModel> {
        return try {
            favoritesDao.addSongToFavorites(favoritesDbModel)
            ResponseResult.Success(favoritesDbModel)
        } catch (e: Exception) {
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    /**
     * Retrieves all favorite songs.
     *
     * @return A ResponseResult containing a list of FavoritesDbModel.
     */
    override suspend fun getAllFavoriteSongs(): ResponseResult<List<FavoritesDbModel>> {
        return try {
            val response = favoritesDao.getAllSongs()
            ResponseResult.Success(response)
        } catch (e: Exception) {
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    /**
     * Deletes a song from favorites.
     *
     * @param favoritesDbModel The FavoritesDbModel to be deleted.
     * @return A ResponseResult containing the deleted FavoritesDbModel.
     */
    override suspend fun deleteSongToFavorites(favoritesDbModel: FavoritesDbModel): ResponseResult<FavoritesDbModel> {
        return try {
            favoritesDao.deleteSongToFavorites(favoritesDbModel)
            ResponseResult.Success(favoritesDbModel)
        } catch (e: Exception) {
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    /**
     * Retrieves a favorite song with a specific ID.
     *
     * @param id The ID of the favorite song to be retrieved.
     * @return A ResponseResult containing the retrieved FavoritesDbModel.
     */
    override suspend fun getFavoriteSongWithId(id: Int): ResponseResult<FavoritesDbModel> {
        return try {
            val response = favoritesDao.getFavoriteSongWithId(id)
            ResponseResult.Success(response)
        } catch (e: Exception) {
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }
}