package com.example.domain.usecase.getAllFavoriteSongs

import com.example.common.ResponseResult
import com.example.domain.entity.FavoritesEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

class GetAllFavoriteSongsUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository
):GetAllFavoriteSongsUseCase {
    override suspend fun invoke(): ResponseResult<List<FavoritesEntity>> {
        return deezerRepository.getAllFavoriteSongs()
    }
}