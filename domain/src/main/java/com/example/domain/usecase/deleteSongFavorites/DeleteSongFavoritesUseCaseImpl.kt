package com.example.domain.usecase.deleteSongFavorites

import com.example.common.ResponseResult
import com.example.domain.entity.FavoritesEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

class DeleteSongFavoritesUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository
):DeleteSongFavoritesUseCase {
    override suspend fun invoke(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity> {
        return deezerRepository.deleteSongToFavorites(favoritesEntity)
    }
}