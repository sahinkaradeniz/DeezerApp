package com.example.domain.di

import com.example.domain.usecase.addSongToFavorites.AddSongToFavoritesUseCase
import com.example.domain.usecase.addSongToFavorites.AddSongToFavoritesUseCaseImpl
import com.example.domain.usecase.deleteSongFavorites.DeleteSongFavoritesUseCase
import com.example.domain.usecase.deleteSongFavorites.DeleteSongFavoritesUseCaseImpl
import com.example.domain.usecase.getAllFavoriteSongs.GetAllFavoriteSongsUseCase
import com.example.domain.usecase.getAllFavoriteSongs.GetAllFavoriteSongsUseCaseImpl
import com.example.domain.usecase.getAllGenresOfMusic.GetAllGenresOfMusicUseCase
import com.example.domain.usecase.getAllGenresOfMusic.GetAllGenresOfMusicUseCaseImpl
import com.example.domain.usecase.getFavoriteSongWithId.GetFavoriteSongWithIdUseCase
import com.example.domain.usecase.getFavoriteSongWithId.GetFavoriteSongWithIdUseCaseImpl
import com.example.domain.usecase.getGenreArtistsWithGenreId.GetGenreArtistsWithGenreIdUseCase
import com.example.domain.usecase.getGenreArtistsWithGenreId.GetGenreArtistsWithGenreIdUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindAddSongToFavoritesUseCase(addSongToFavoritesUseCaseImpl: AddSongToFavoritesUseCaseImpl): AddSongToFavoritesUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteSongFavoriteUseCase(deleteSongFavoritesUSeCaseImpl:DeleteSongFavoritesUseCaseImpl):DeleteSongFavoritesUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllFavoriteSongsUseCase(getAllFavoriteSongsUseCaseImpl: GetAllFavoriteSongsUseCaseImpl):GetAllFavoriteSongsUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetFavoriteSongWitIdUseCase(getFavoriteSongWithIdUseCaseImpl: GetFavoriteSongWithIdUseCaseImpl):GetFavoriteSongWithIdUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllGenresOfMusicUseCase(getAllGenresOfMusicUseCaseImpl: GetAllGenresOfMusicUseCaseImpl):GetAllGenresOfMusicUseCase

    @Binds
    @ViewModelScoped
    abstract fun bingGetGenreArtistsWithGenreIdUseCase(getGenreArtistsWithGenreIdUseCaseImpl: GetGenreArtistsWithGenreIdUseCaseImpl):GetGenreArtistsWithGenreIdUseCase
}