package com.example.domain.repository

import com.example.common.ResponseResult
import com.example.domain.entity.*

interface DeezerRepository {
    suspend fun addSongToFavorites(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity>

    suspend fun getAllFavoriteSongs(): ResponseResult<List<FavoritesEntity>>

    suspend fun deleteSongToFavorites(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity>

    suspend fun getFavoriteSongWithId(id: Int): ResponseResult<FavoritesEntity>

    suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreEntity>>

    suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsEntity>>

    suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistEntity>

    suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsEntity>>

    suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksEntity>>
}