package com.example.domain.usecase.addSongToFavorites

import com.example.common.ResponseResult
import com.example.domain.entity.FavoritesEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

/**
 * Implementation of the AddSongToFavoritesUseCase.
 *
 * @param deezerRepository The DeezerRepository to interact with Deezer data.
 */
class AddSongToFavoritesUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository
) : AddSongToFavoritesUseCase {

    /**
     * Adds a song to favorites.
     *
     * @param favoritesEntity The FavoritesEntity to add.
     * @return ResponseResult containing the added FavoritesEntity.
     */
    override suspend fun invoke(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity> {
        return deezerRepository.addSongToFavorites(favoritesEntity)
    }
}
