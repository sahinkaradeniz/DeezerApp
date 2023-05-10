package com.example.domain.usecase

import com.example.common.ResponseResult
import com.example.domain.entity.FavoritesEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

class AddSongToFavoritesUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository
):AddSongToFavoritesUseCase {
    override suspend fun invoke(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity> {
       return deezerRepository.addSongToFavorites(favoritesEntity)
    }
}