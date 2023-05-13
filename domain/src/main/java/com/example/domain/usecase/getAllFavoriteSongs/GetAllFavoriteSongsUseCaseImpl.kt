package com.example.domain.usecase.getAllFavoriteSongs

import com.example.common.ResponseResult
import com.example.domain.entity.FavoritesEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

/**
 * Implementation of the GetAllFavoriteSongsUseCase.
 *
 * @param deezerRepository The DeezerRepository to interact with Deezer data.
 */
class GetAllFavoriteSongsUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository
) : GetAllFavoriteSongsUseCase {

    /**
     * Retrieves all favorite songs.
     *
     * @return ResponseResult containing the list of FavoritesEntity.
     */
    override suspend fun invoke(): ResponseResult<List<FavoritesEntity>> {
        return deezerRepository.getAllFavoriteSongs()
    }
}
