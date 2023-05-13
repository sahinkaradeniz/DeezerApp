package com.example.data.source.local

import com.example.common.ResponseResult
import com.example.data.dto.favorite.FavoritesDbModel

/**
 * LocalDataSource is the interface for the local data source.
 * It defines methods to perform operations related to favorite songs.
 */
interface LocalDataSource {
    /**
     * Adds a song to favorites.
     *
     * @param favoritesDbModel The FavoritesDbModel to be added.
     * @return A ResponseResult containing the added FavoritesDbModel.
     */
    suspend fun addSongToFavorites(favoritesDbModel: FavoritesDbModel): ResponseResult<FavoritesDbModel>

    /**
     * Retrieves all favorite songs.
     *
     * @return A ResponseResult containing a list of FavoritesDbModel.
     */
    suspend fun getAllFavoriteSongs(): ResponseResult<List<FavoritesDbModel>>

    /**
     * Deletes a song from favorites.
     *
     * @param favoritesDbModel The FavoritesDbModel to be deleted.
     * @return A ResponseResult containing the deleted FavoritesDbModel.
     */
    suspend fun deleteSongToFavorites(favoritesDbModel: FavoritesDbModel): ResponseResult<FavoritesDbModel>

    /**
     * Retrieves a favorite song with a specific ID.
     *
     * @param id The ID of the favorite song to be retrieved.
     * @return A ResponseResult containing the retrieved FavoritesDbModel.
     */
    suspend fun getFavoriteSongWithId(id: Int): ResponseResult<FavoritesDbModel>
}
