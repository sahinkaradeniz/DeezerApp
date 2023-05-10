package com.example.domain.usecase.getAllGenresOfMusic

import com.example.common.ResponseResult
import com.example.domain.entity.MusicGenreEntity

interface GetAllGenresOfMusicUseCase {
    suspend operator fun invoke():ResponseResult<List<MusicGenreEntity>>
}