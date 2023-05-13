package com.example.data.di.source

import com.example.data.source.remote.RemoteDataSource
import com.example.data.source.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * RemoteSourceModule provides remote data source related objects for dependency injection.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteSourceModule {
    /**
     * Binds the RemoteDataSourceImpl to the RemoteDataSource interface.
     *
     * @param remoteDataSourceImpl The implementation of RemoteDataSource.
     * @return The bound RemoteDataSource.
     */
    @Binds
    @Singleton
    abstract fun bindDeezerRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl):RemoteDataSource
}