package com.example.data.di.repository

import com.example.data.repository.DeezerRepositoryImpl
import com.example.domain.repository.DeezerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * RepositoryModule provides repository related objects for dependency injection.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    /**
     * Provides the DeezerRepository.
     *
     * @return The DeezerRepository instance.
     */
    @Binds
    @Singleton
    abstract fun bindDeezerRepository(deezerRepositoryImpl: DeezerRepositoryImpl):DeezerRepository
}