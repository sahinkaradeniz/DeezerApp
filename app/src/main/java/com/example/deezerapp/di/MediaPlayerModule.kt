package com.example.deezerapp.di

import com.example.deezerapp.util.manager.*
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext


@Module
@InstallIn(ActivityRetainedComponent::class)
object MediaPlayerModule {

    @Provides
    fun provideMediaPlayerManager(@ApplicationContext context: Context):MediaPlayerManager{
        return MediaPlayerManager(context)
    }
}