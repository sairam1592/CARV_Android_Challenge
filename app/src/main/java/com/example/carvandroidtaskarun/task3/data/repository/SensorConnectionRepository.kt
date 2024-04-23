package com.example.carvandroidtaskarun.task3.data.repository

import kotlinx.coroutines.flow.Flow

interface SensorConnectionRepository {
    fun observeConnection(): Flow<Boolean>
}