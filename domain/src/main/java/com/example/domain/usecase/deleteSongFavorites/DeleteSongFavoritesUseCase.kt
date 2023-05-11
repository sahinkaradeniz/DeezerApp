package com.example.domain.usecase.deleteSongFavorites

import com.example.common.ResponseResult
import com.example.domain.entity.FavoritesEntity

interface DeleteSongFavoritesUseCase {
    suspend operator fun invoke(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity>
}