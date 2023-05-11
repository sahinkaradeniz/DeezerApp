package com.example.deezerapp.ui.artist

import com.example.common.mapper.DeezerMapper
import com.example.domain.entity.ArtistEntity
import javax.inject.Inject

class ArtistUiMapper @Inject constructor() :DeezerMapper<ArtistEntity,ArtistUiData>{
    override fun map(input: ArtistEntity): ArtistUiData {
        return ArtistUiData(
            id = input.id,
            name = input.name,
            picture = input.picture,
            albums = arrayListOf()
        )
    }
}