package com.example.domain.usecase.getAllGenresOfMusic

import com.example.common.ResponseResult
import com.example.domain.entity.MusicGenreEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

/**
 * Implementation of the GetAllGenresOfMusicUseCase.
 *
 * @param deezerRepository The DeezerRepository to interact with Deezer data.
 */
class GetAllGenresOfMusicUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository
) : GetAllGenresOfMusicUseCase {

    /**
     * Retrieves all genres of music.
     *
     * @return ResponseResult containing the list of MusicGenreEntity.
     */
    override suspend fun invoke(): ResponseResult<List<MusicGenreEntity>> {
        return deezerRepository.getAllGenresOfMusic()
    }
}
