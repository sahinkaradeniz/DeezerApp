package com.example.domain.usecase.getArtistAlbumsWithArtistId

import com.example.common.ResponseResult
import com.example.domain.entity.ArtistAlbumsEntity

interface GetArtistAlbumsWithArtistIdUseCase {
    suspend operator fun invoke(artistId:Int):ResponseResult<List<ArtistAlbumsEntity>>
}