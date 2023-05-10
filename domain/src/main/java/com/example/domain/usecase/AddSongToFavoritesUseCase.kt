package com.example.domain.usecase

import com.example.common.ResponseResult
import com.example.domain.entity.FavoritesEntity

interface AddSongToFavoritesUseCase {
    suspend operator fun invoke(favoritesEntity: FavoritesEntity):ResponseResult<FavoritesEntity>
}