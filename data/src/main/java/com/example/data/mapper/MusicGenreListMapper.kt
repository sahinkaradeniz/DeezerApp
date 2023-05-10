package com.example.data.mapper

import com.example.common.mapper.DeezerListMapper
import com.example.data.dto.genre.MusicGenreData
import com.example.domain.entity.MusicGenreEntity

class MusicGenreListMapper:DeezerListMapper<MusicGenreData,MusicGenreEntity> {
    override fun map(input: List<MusicGenreData>): List<MusicGenreEntity> {
        return input.map {
            MusicGenreEntity(
                id = it.id,
                name = it.name,
                picture = it.picture,
            )
        }
    }
}