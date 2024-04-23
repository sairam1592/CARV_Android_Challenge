package com.example.carvandroidtaskarun.task2.network

import com.example.carvandroidtaskarun.task2.data.model.AppEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class EventManager {
    private val _events = MutableSharedFlow<AppEvent>(extraBufferCapacity = 1)
    val events = _events.asSharedFlow()

    // Generic function made private to enforce type safety through specific functions
    private suspend fun <T : AppEvent> publishEvent(event: T) {
        _events.emit(event)
    }

    // Type-specific functions for publishing events
    suspend fun publishTemperatureChanged(temperature: Float) {
        publishEvent(AppEvent.TemperatureChanged(temperature))
    }

    suspend fun publishMessageReceived(message: String) {
        publishEvent(AppEvent.MessageReceived(message))
    }

    suspend fun publishNotificationReceived(notification: String) {
        publishEvent(AppEvent.NotificationReceived(notification))
    }

    suspend fun publishBluetoothPermissionChanged() {
        publishEvent(AppEvent.BluetoothPermissionChanged)
    }
}