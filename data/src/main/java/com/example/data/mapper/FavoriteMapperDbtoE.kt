package com.example.data.mapper

import com.example.common.mapper.DeezerMapper
import com.example.data.dto.favorite.FavoritesDbModel
import com.example.domain.entity.FavoritesEntity
import javax.inject.Inject

class FavoriteMapperDbtoE @Inject constructor():DeezerMapper<FavoritesDbModel,FavoritesEntity> {
    override fun map(input: FavoritesDbModel): FavoritesEntity {
        return FavoritesEntity(
            id = input.id,
            artistName = input.artistName,
            title = input.title,
            duration = input.duration,
            picture = input.picture
        )
    }
}