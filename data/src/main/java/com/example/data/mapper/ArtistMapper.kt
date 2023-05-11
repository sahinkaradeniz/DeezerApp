package com.example.data.mapper

import com.example.common.mapper.DeezerMapper
import com.example.data.dto.artist.ArtistResponse
import com.example.domain.entity.ArtistEntity
import javax.inject.Inject

class ArtistMapper @Inject constructor():DeezerMapper<ArtistResponse,ArtistEntity> {
    override fun map(input: ArtistResponse): ArtistEntity {
        return ArtistEntity(
           id= input.id,
            name = input.name,
            type = input.type,
            tracklist = input.tracklist,
            picture = input.pictureMedium
        )
    }
}