package com.example.domain.di

import com.example.domain.usecase.AddSongToFavoritesUseCase
import com.example.domain.usecase.AddSongToFavoritesUseCaseImpl
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
    abstract fun bindAddSongToFavoritesUSeCase(addSongToFavoritesUseCaseImpl: AddSongToFavoritesUseCaseImpl):AddSongToFavoritesUseCase
}