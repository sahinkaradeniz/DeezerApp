package com.example.data.mapper

import com.example.common.mapper.DeezerListMapper
import com.example.data.dto.genre_artists.GenreArtistsData
import com.example.domain.entity.GenreArtistsEntity

class GenreArtistListMapper:DeezerListMapper<GenreArtistsData,GenreArtistsEntity> {
    override fun map(input: List<GenreArtistsData>): List<GenreArtistsEntity> {
       return input.map {
            GenreArtistsEntity(
                id = it.id,
                name = it.name,
                picture = it.picture,
                type = it.type,
                tracklist = it.tracklist
            )
        }
    }
}