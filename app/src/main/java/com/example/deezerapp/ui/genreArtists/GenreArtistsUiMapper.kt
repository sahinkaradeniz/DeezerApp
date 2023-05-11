package com.example.deezerapp.ui.genreArtists

import com.example.common.mapper.DeezerListMapper
import com.example.domain.entity.GenreArtistsEntity
import javax.inject.Inject

class GenreArtistsUiMapper @Inject constructor() :
    DeezerListMapper<GenreArtistsEntity, GenreArtistsUiData> {
    override fun map(input: List<GenreArtistsEntity>): List<GenreArtistsUiData> {
        return input.map {
            GenreArtistsUiData(
                id = it.id,
                picture = it.picture,
                name = it.name
            )
        }
    }
}