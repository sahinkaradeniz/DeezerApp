package com.example.deezerapp.ui.albumTracks

import com.example.common.mapper.DeezerListMapper
import com.example.domain.entity.AlbumTracksEntity
import javax.inject.Inject

class TracksUiMapper @Inject constructor() : DeezerListMapper<AlbumTracksEntity, TracksUiData> {
    override fun map(input: List<AlbumTracksEntity>): List<TracksUiData> {
        return input.map {
            TracksUiData(
                id = it.id,
                duration = it.duration,
                title = it.title,
                preview = it.preview,
                artist = it.artist
            )
        }
    }
}