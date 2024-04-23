package com.example.carvandroidtaskarun.task2.data.model

sealed class AppEvent {
    data object BluetoothPermissionChanged : AppEvent()
    data class MessageReceived(val message: String) : AppEvent()
    data class NotificationReceived(val notification: String) : AppEvent()
    data class TemperatureChanged(val temperature: Float) : AppEvent()
    data class AccelerometerDataUpdated(val data: AccelerometerData) : AppEvent()
}

data class AccelerometerData(val x: Float, val y: Float, val z: Float)