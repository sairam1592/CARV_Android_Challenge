package com.example.carvandroidtaskarun.task2.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carvandroidtaskarun.task2.data.model.AccelerometerData
import com.example.carvandroidtaskarun.task2.data.model.AppEvent
import com.example.carvandroidtaskarun.task2.network.EventManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val eventManager: EventManager
) : ViewModel() {

    init {
        viewModelScope.launch {
            eventManager.events.collect { event ->
                when (event) {
                    is AppEvent.BluetoothPermissionChanged -> subscribeBluetoothPermissionChanged()
                    is AppEvent.MessageReceived -> subscribeMessageReceived(event.message)
                    is AppEvent.NotificationReceived -> subscribeNotificationReceived(event.notification)
                    is AppEvent.TemperatureChanged -> subscribeTemperatureChanged(event.temperature)
                    is AppEvent.AccelerometerDataUpdated -> subscribeAccelerometerDataUpdated(event.data)
                }
            }
        }
    }

    /**
     * Subscribe related method go below, the UI updates will be done here, we pass the relevant info via a StateFlow to Composable screen
     */
    private fun subscribeMessageReceived(message: String) {
        // Handle message received event
    }

    private fun subscribeNotificationReceived(notification: String) {
        // Handle notification received event
    }

    private fun subscribeBluetoothPermissionChanged() {
        // Handle Bluetooth permission changed event
    }

    private fun subscribeTemperatureChanged(temperature: Float) {
        // Handle temperature changed event
    }

    private fun subscribeAccelerometerDataUpdated(data: AccelerometerData) {
        // Handle accelerometer data updated event
    }

    /**
     * Publish related method go below
     */
    fun publishTemperature(temperature: Float) {
        viewModelScope.launch {
            eventManager.publishTemperatureChanged(temperature)
        }
    }

    fun publishMessage(message: String) {
        viewModelScope.launch {
            eventManager.publishMessageReceived(message)
        }
    }

    fun publishNotification(notification: String) {
        viewModelScope.launch {
            eventManager.publishNotificationReceived(notification)
        }
    }

    fun publishBluetoothPermissionChange() {
        viewModelScope.launch {
            eventManager.publishBluetoothPermissionChanged()
        }
    }
}