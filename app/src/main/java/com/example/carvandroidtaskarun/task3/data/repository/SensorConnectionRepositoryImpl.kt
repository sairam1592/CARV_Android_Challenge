package com.example.carvandroidtaskarun.task3.data.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SensorConnectionRepositoryImpl @Inject constructor() : SensorConnectionRepository {

    override fun observeConnection(): Flow<Boolean> = flow {
        var lastDisconnectTime: Long? = null
        var isConnected = true

        for (second in 0..Int.MAX_VALUE) {
            delay(1000)

            val shouldBeConnected = second % 5 == 0 || second % 3 != 0

            if (isConnected != shouldBeConnected) {
                lastDisconnectTime = if (shouldBeConnected) null else System.currentTimeMillis()
                isConnected = shouldBeConnected
            } else if (!shouldBeConnected) {
                lastDisconnectTime?.let {
                    if (System.currentTimeMillis() - it >= 3500) {
                        isConnected = false
                    }
                }
            }

            emit(isConnected)
        }
    }
}