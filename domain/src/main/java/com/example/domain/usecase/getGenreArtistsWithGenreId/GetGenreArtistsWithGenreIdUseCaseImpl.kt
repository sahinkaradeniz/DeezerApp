package com.example.domain.usecase.getGenreArtistsWithGenreId

import com.example.common.ResponseResult
import com.example.domain.entity.GenreArtistsEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

/**
 * Implementation of the GetGenreArtistsWithGenreIdUseCase.
 *
 * @param deezerRepository The DeezerRepository to interact with Deezer data.
 */
class GetGenreArtistsWithGenreIdUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository,
) : GetGenreArtistsWithGenreIdUseCase {
    /**
     * Retrieves artists with the specified genre ID.
     *
     * @param genreId The ID of the music genre.
     * @return ResponseResult containing the list of GenreArtistsEntity.
     */
    override suspend fun invoke(genreId: Int): ResponseResult<List<GenreArtistsEntity>> {
        return deezerRepository.getGenreArtistsWithGenreId(genreId)
    }
}