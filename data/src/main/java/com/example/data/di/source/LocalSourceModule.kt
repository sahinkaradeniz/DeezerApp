package com.example.data.di.source

import com.example.data.source.local.LocalDataSource
import com.example.data.source.local.LocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * LocalSourceModule provides local data source related objects for dependency injection.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModule {
    /**
     * Binds the LocalDataSourceImpl to the LocalDataSource interface.
     *
     * @param localDataSourceImpl The implementation of LocalDataSource.
     * @return The bound LocalDataSource.
     */
    @Binds
    @Singleton
    abstract fun bindLocalSource(localDataSourceImpl: LocalDataSourceImpl):LocalDataSource
}