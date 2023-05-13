package com.example.domain.usecase.deleteSongFavorites

import com.example.common.ResponseResult
import com.example.domain.entity.FavoritesEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

/**
 * Implementation of the DeleteSongFavoritesUseCase.
 *
 * @param deezerRepository The DeezerRepository to interact with Deezer data.
 */
class DeleteSongFavoritesUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository
) : DeleteSongFavoritesUseCase {

    /**
     * Deletes a song from favorites.
     *
     * @param favoritesEntity The FavoritesEntity to delete.
     * @return ResponseResult containing the deleted FavoritesEntity.
     */
    override suspend fun invoke(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity> {
        return deezerRepository.deleteSongToFavorites(favoritesEntity)
    }
}
