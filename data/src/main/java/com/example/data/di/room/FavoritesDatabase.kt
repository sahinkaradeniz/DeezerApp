package com.example.data.di.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.datastore.room.FavoritesDao
import com.example.data.dto.favorite.FavoritesDbModel

/**
 * FavoritesDatabase represents a Room database for favorite songs.
 * Contains a single table represented by FavoritesDbModel class.
 */
@Database(entities = [FavoritesDbModel::class], version = 1, exportSchema = false)
abstract class FavoritesDatabase:RoomDatabase() {
    /**
     * Returns a reference to the FavoritesDao for accessing the favorites table.
     *
     * @return The FavoritesDao.
     */
    abstract fun favoritesDao(): FavoritesDao
}