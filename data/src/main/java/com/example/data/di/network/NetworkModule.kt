package com.example.data.di.network

import com.example.data.datastore.api.DeezerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
/**
 * NetworkModule provides network related objects for dependency injection.
 */
object NetworkModule {
    /**
     * Provides the DeezerApi.
     *
     * @return The DeezerApi instance.
     */
    @Provides
    @Singleton
    fun provideDeezerApi(): DeezerApi {
        return Retrofit.Builder()
            .baseUrl("https://api.deezer.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DeezerApi::class.java)
    }
}