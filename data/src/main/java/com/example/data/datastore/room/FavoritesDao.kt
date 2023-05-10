package com.example.data.datastore.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.dto.favorite.FavoritesDbModel

@Dao
interface FavoritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSongToFavorites(song: FavoritesDbModel)
    @Delete
    suspend fun deleteSongToFavorites(song: FavoritesDbModel)

    @Query("select * from favorites_table")
    suspend fun getAllSongs():List<FavoritesDbModel>

    @Query("select * from favorites_table where :id")
    suspend fun getFavoriteSongWithId(id:Int):FavoritesDbModel
    
}