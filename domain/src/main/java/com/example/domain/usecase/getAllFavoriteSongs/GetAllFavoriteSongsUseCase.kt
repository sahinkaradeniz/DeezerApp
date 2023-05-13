package com.example.domain.usecase.getAllFavoriteSongs

import com.example.common.ResponseResult
import com.example.domain.entity.FavoritesEntity

interface GetAllFavoriteSongsUseCase {
    suspend operator fun invoke():ResponseResult<List<FavoritesEntity>>
}