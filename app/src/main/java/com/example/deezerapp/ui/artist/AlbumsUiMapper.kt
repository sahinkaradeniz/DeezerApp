package com.example.deezerapp.ui.artist

import com.example.common.mapper.DeezerListMapper
import com.example.domain.entity.ArtistAlbumsEntity
import javax.inject.Inject

class AlbumsUiMapper @Inject constructor():DeezerListMapper<ArtistAlbumsEntity,AlbumsUiData> {
    override fun map(input: List<ArtistAlbumsEntity>): List<AlbumsUiData> {
        return input.map {
            AlbumsUiData(
                id = it.id,
                title = it.title,
                picture = it.picture,
                date = it.date
            )
        }
    }
}