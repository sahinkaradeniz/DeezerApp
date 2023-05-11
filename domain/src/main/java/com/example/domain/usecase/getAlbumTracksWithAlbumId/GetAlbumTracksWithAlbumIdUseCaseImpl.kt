package com.example.domain.usecase.getAlbumTracksWithAlbumId

import com.example.common.ResponseResult
import com.example.domain.entity.AlbumTracksEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

class GetAlbumTracksWithAlbumIdUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository,
) : GetAlbumTracksWithAlbumIdUseCase {
    override suspend fun invoke(albumId: Int): ResponseResult<List<AlbumTracksEntity>> {
        return deezerRepository.getAlbumTracksWithAlbumId(albumId)
    }
}