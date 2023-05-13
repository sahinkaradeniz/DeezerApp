package com.example.data.dto.favorite

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites_table")
data class FavoritesDbModel(
    @PrimaryKey
    var id: Int,
    var title: String,
    var duration: Int,
    var artistName: String,
    var picture:String
)