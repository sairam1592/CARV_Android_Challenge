package com.example.carvandroidtaskarun.task3.di

import com.example.carvandroidtaskarun.task3.data.repository.SensorConnectionRepository
import com.example.carvandroidtaskarun.task3.data.repository.SensorConnectionRepositoryImpl
import com.example.carvandroidtaskarun.task3.domain.usecase.CheckSensorConnectionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ConnectionModule {


    @Provides
    fun provideSensorConnectionRepository(
        sensorConnectionRepositoryImpl: SensorConnectionRepositoryImpl
    ): SensorConnectionRepository {
        return sensorConnectionRepositoryImpl
    }

    @Provides
    fun provideCheckConnectionUseCase(repository: SensorConnectionRepository): CheckSensorConnectionUseCase {
        return CheckSensorConnectionUseCase(repository)
    }
}