package com.example.data.di.repository

import com.example.data.repository.DeezerRepositoryImpl
import com.example.domain.repository.DeezerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDeezerRepository(deezerRepositoryImpl: DeezerRepositoryImpl):DeezerRepository
}