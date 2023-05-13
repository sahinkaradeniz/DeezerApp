package com.example.data.di.coroutine

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
/**
 * CoroutineDispatchersModule provides Coroutine Dispatcher related objects for dependency injection.
 */
object CoroutineDispatchersModule {

    /**
     * Provides the I/O dispatcher for Coroutines.
     *
     * @return The Coroutine I/O Dispatcher.
     */
    @IoDispatcher
    @Provides
    @Singleton
    fun providesIoDispatcher() = Dispatchers.IO
}