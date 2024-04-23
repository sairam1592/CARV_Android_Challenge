package com.example.carvandroidtaskarun.task3.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carvandroidtaskarun.task3.domain.usecase.CheckSensorConnectionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SensorConnectionViewModel @Inject constructor(
    private val checkSensorConnectionUseCase: CheckSensorConnectionUseCase
) : ViewModel() {

    private val _connectionStatus = MutableStateFlow(true)
    val connectionStatus: StateFlow<Boolean> = _connectionStatus.asStateFlow()

    init {
        viewModelScope.launch {
            checkSensorConnectionUseCase().collect {
                _connectionStatus.value = it
            }
        }
    }
}