package com.example.data.di.mapper

import com.example.common.mapper.DeezerListMapper
import com.example.common.mapper.DeezerMapper
import com.example.data.dto.albumTracks.AlbumTracksData
import com.example.data.dto.artist.ArtistResponse
import com.example.data.dto.artistAlbums.ArtistAlbumsData
import com.example.data.dto.favorite.FavoritesDbModel
import com.example.data.dto.genre.MusicGenreData
import com.example.data.dto.genreArtists.GenreArtistsData
import com.example.data.mapper.*
import com.example.domain.entity.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {
    @Binds
    @Singleton
    abstract fun bindArtistAlbumsListMapper(artistAlbumsListMapper: ArtistAlbumsListMapper): DeezerListMapper<ArtistAlbumsData, ArtistAlbumsEntity>

    @Binds
    @Singleton
    abstract fun bindArtistMapper(artistMapper: ArtistMapper): DeezerMapper<ArtistResponse, ArtistEntity>

    @Binds
    @Singleton
    abstract fun bindFavoriteMapperDbToE(favoriteMapperDbToE: FavoriteMapperDbtoE): DeezerMapper<FavoritesDbModel, FavoritesEntity>

    @Binds
    @Singleton
    abstract fun bindFavoriteMapperEtoDb(favoriteMapperEtoDb: FavoriteMapperEtoDb): DeezerMapper<FavoritesEntity, FavoritesDbModel>

    @Binds
    @Singleton
    abstract fun bindFavoriteListMapper(favoriteListMapper: FavoritesListMapper): DeezerListMapper<FavoritesDbModel, FavoritesEntity>

    @Binds
    @Singleton
    abstract fun bindGenreArtistListMapper(genreArtistListMapper: GenreArtistListMapper): DeezerListMapper<GenreArtistsData, GenreArtistsEntity>

    @Binds
    @Singleton
    abstract fun bindMusicGenreListMapper(musicGenreListMapper: MusicGenreListMapper): DeezerListMapper<MusicGenreData, MusicGenreEntity>

    @Binds
    @Singleton
    abstract fun bindAlbumTracksListMapper(albumTracksListMapper: AlbumTracksListMapper):DeezerListMapper<AlbumTracksData,AlbumTracksEntity>
}