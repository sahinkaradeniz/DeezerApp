package com.example.domain.usecase.getGenreArtistsWithGenreId

import com.example.common.ResponseResult
import com.example.domain.entity.GenreArtistsEntity

interface GetGenreArtistsWithGenreIdUseCase {
    suspend operator fun invoke(genreId:Int):ResponseResult<List<GenreArtistsEntity>>
}