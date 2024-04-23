package com.example.carvandroidtaskarun.task2.di

import com.example.carvandroidtaskarun.task2.network.EventManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideEventManager() = EventManager()
}