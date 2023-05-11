package com.example.domain.usecase.getAlbumTracksWithAlbumId

import com.example.common.ResponseResult
import com.example.domain.entity.AlbumTracksEntity

interface GetAlbumTracksWithAlbumIdUseCase {
    suspend operator fun invoke(albumId: Int): ResponseResult<List<AlbumTracksEntity>>
}