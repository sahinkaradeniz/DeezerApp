package com.example.domain.usecase.getArtistAlbumsWithArtistId

import com.example.common.ResponseResult
import com.example.domain.entity.ArtistAlbumsEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

class GetArtistAlbumsWithArtistIdUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository
):GetArtistAlbumsWithArtistIdUseCase {
    override suspend fun invoke(artistId: Int): ResponseResult<List<ArtistAlbumsEntity>> {
        return deezerRepository.getArtistAlbumsWithArtistId(artistId)
    }
}