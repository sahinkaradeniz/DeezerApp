package com.example.data.datastore.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.dto.favorite.FavoritesDbModel


/**
 * FavoritesDao defines database operations related to favorite songs.
 */
@Dao
interface FavoritesDao {
    /**
     * Adds a song to favorites.
     *
     * @param song The song to be added to favorites.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSongToFavorites(song: FavoritesDbModel)

    /**
     * Deletes a song from favorites.
     *
     * @param song The song to be deleted from favorites.
     */
    @Delete
    suspend fun deleteSongToFavorites(song: FavoritesDbModel)

    /**
     * Retrieves all favorite songs.
     *
     * @return A list of FavoritesDbModel representing the favorite songs.
     */
    @Query("select * from favorites_table")
    suspend fun getAllSongs():List<FavoritesDbModel>

    /**
     * Retrieves a favorite song with a specific ID.
     *
     * @param id The ID of the favorite song to be retrieved.
     * @return A FavoritesDbModel representing the favorite song with the given ID.
     */
    @Query("select * from favorites_table where :id")
    suspend fun getFavoriteSongWithId(id:Int):FavoritesDbModel
    
}