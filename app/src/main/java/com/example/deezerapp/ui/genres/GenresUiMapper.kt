package com.example.deezerapp.ui.genres

import com.example.common.mapper.DeezerMapper
import com.example.domain.entity.MusicGenreEntity
import javax.inject.Inject

class GenresUiMapper @Inject constructor():DeezerMapper<MusicGenreEntity,GenresUiData> {
    override fun map(input: MusicGenreEntity): GenresUiData {
        return GenresUiData(
            id = input.id,
            picture = input.picture,
            name = input.name
        )
    }
}