package com.example.domain.usecase.getGenreArtistsWithGenreId

import com.example.common.ResponseResult
import com.example.domain.entity.GenreArtistsEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

class GetGenreArtistsWithGenreIdUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository,
) : GetGenreArtistsWithGenreIdUseCase {
    override suspend fun invoke(genreId: Int): ResponseResult<List<GenreArtistsEntity>> {
        return deezerRepository.getGenreArtistsWithGenreId(genreId)
    }
}