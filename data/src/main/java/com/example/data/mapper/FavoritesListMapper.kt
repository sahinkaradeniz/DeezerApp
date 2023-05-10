package com.example.data.mapper

import com.example.common.mapper.DeezerListMapper
import com.example.data.dto.favorite.FavoritesDbModel
import com.example.domain.entity.FavoritesEntity

class FavoritesListMapper:DeezerListMapper<FavoritesDbModel,FavoritesEntity> {
    override fun map(input: List<FavoritesDbModel>): List<FavoritesEntity> {
        return input.map {
            FavoritesEntity(
                id = it.id,
                artistName = it.artistName,
                title = it.title,
                duration = it.duration,
                picture = it.picture
            )
        }
    }
}