package com.example.domain.usecase.getAllGenresOfMusic

import com.example.common.ResponseResult
import com.example.domain.entity.MusicGenreEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

class GetAllGenresOfMusicUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository,
) : GetAllGenresOfMusicUseCase {
    override suspend fun invoke(): ResponseResult<List<MusicGenreEntity>> {
        return deezerRepository.getAllGenresOfMusic()
    }
}