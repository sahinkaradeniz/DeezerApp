package com.example.data.dto.favorite

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.dto.album_tracks.Artist

@Entity(tableName = "favorites_table")
data class FavoritesDbModel(
    @PrimaryKey
    var id: Int,
    var title: String,
    var duration: Int,
    var artist: Artist,
)