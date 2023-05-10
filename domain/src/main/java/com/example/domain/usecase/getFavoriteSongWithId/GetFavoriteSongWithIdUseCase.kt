package com.example.domain.usecase.getFavoriteSongWithId

import com.example.common.ResponseResult
import com.example.domain.entity.FavoritesEntity

interface GetFavoriteSongWithIdUseCase{
    suspend operator fun invoke(id:Int):ResponseResult<FavoritesEntity>
}