package com.example.carvandroidtaskarun.task3.data.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SensorConnectionRepositoryImpl @Inject constructor() : SensorConnectionRepository {
    override fun observeConnection(): Flow<Boolean> = flow {
        var disconnectStartTime: Long? = null

        emit(true)

        for (second in 0 until Int.MAX_VALUE) {
            delay(1000)

            val isConnected = when {
                second % 15 == 0 -> true
                second % 5 == 0 -> true
                second % 3 == 0 -> false
                else -> true
            }

            val currentTime = System.currentTimeMillis()
            if (isConnected) {
                disconnectStartTime = null
                emit(true)
            } else if (disconnectStartTime == null) {
                disconnectStartTime = currentTime
            } else if (currentTime - disconnectStartTime >= 3500) {
                emit(false)
            }
        }
    }
}