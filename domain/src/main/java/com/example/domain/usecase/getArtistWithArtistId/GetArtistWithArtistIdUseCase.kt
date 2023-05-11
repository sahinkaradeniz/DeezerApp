package com.example.domain.usecase.getArtistWithArtistId

import com.example.common.ResponseResult
import com.example.domain.entity.ArtistEntity

interface GetArtistWithArtistIdUseCase {
    suspend operator fun invoke(artistId: Int):ResponseResult<ArtistEntity>
}