package com.example.carvandroidtaskarun.task3.domain.usecase

import com.example.carvandroidtaskarun.task3.data.repository.SensorConnectionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CheckSensorConnectionUseCase @Inject constructor(private val repository: SensorConnectionRepository) {
    operator fun invoke(): Flow<Boolean> = repository.observeConnection()
}