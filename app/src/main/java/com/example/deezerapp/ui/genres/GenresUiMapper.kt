package com.example.deezerapp.ui.genres

import com.example.common.mapper.DeezerListMapper
import com.example.common.mapper.DeezerMapper
import com.example.domain.entity.MusicGenreEntity
import javax.inject.Inject

class GenresUiMapper @Inject constructor():DeezerListMapper<MusicGenreEntity,GenresUiData> {
    override fun map(input: List<MusicGenreEntity>): List<GenresUiData> {
        return input.map {
            GenresUiData(
                id = it.id,
                picture = it.picture,
                name = it.name
            )
        }
    }

}