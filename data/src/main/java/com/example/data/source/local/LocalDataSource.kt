package com.example.data.source.local

import com.example.common.ResponseResult
import com.example.data.dto.favorite.FavoritesDbModel

interface LocalDataSource {
    suspend fun addSongToFavorites(favoritesDbModel: FavoritesDbModel): ResponseResult<FavoritesDbModel>

    suspend fun getAllFavoriteSongs(): ResponseResult<List<FavoritesDbModel>>

    suspend fun deleteSongToFavorites(favoritesDbModel: FavoritesDbModel): ResponseResult<FavoritesDbModel>

    suspend fun getFavoriteSongWithId(id: Int): ResponseResult<FavoritesDbModel>
}