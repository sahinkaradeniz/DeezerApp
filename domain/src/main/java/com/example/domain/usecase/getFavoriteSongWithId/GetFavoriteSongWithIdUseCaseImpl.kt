package com.example.domain.usecase.getFavoriteSongWithId

import com.example.common.ResponseResult
import com.example.domain.entity.FavoritesEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

class GetFavoriteSongWithIdUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository,
) : GetFavoriteSongWithIdUseCase {
    override suspend fun invoke(id: Int): ResponseResult<FavoritesEntity> {
        return deezerRepository.getFavoriteSongWithId(id)
    }
}