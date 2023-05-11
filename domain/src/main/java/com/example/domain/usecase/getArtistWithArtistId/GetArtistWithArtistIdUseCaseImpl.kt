package com.example.domain.usecase.getArtistWithArtistId

import com.example.common.ResponseResult
import com.example.domain.entity.ArtistEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

class GetArtistWithArtistIdUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository,
) : GetArtistWithArtistIdUseCase {
    override suspend fun invoke(artistId: Int): ResponseResult<ArtistEntity> {
        return deezerRepository.getArtistWithArtistId(artistId)
    }

}