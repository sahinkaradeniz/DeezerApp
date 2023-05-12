package com.example.domain.usecase.getFavoriteSongWithId

import com.example.common.ResponseResult
import com.example.domain.entity.FavoritesEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

/**
 * Implementation of the GetFavoriteSongWithIdUseCase.
 *
 * @param deezerRepository The DeezerRepository to interact with Deezer data.
 */
class GetFavoriteSongWithIdUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository
) : GetFavoriteSongWithIdUseCase {

    /**
     * Retrieves the favorite song with the specified ID.
     *
     * @param id The ID of the favorite song.
     * @return ResponseResult containing the FavoritesEntity.
     */
    override suspend fun invoke(id: Int): ResponseResult<FavoritesEntity> {
        return deezerRepository.getFavoriteSongWithId(id)
    }
}
