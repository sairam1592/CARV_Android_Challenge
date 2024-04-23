package com.example.carvandroidtaskarun.task1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carvandroidtaskarun.task1.data.model.CircleDataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CircleViewModel : ViewModel() {

    private val _circleState = MutableStateFlow<List<CircleDataModel>>(emptyList())
    val circleState: StateFlow<List<CircleDataModel>> = _circleState

    init {
        loadCircles()
    }

    private fun loadCircles() {
        viewModelScope.launch {
            val circles = listOf(
                CircleDataModel(18.81799, 35.7445, 10.0),
                CircleDataModel(37.39319, 208.1334, 12.0),
                CircleDataModel(23.13299, 16.8974, 12.0),
                CircleDataModel(16.21079, 0.0, 12.0),
                CircleDataModel(4.51639, 12.8394, 12.0),
                CircleDataModel(32.11859, 65.6744, 12.0),
                CircleDataModel(34.12719, 84.2464, 12.0),
                CircleDataModel(20.07639, 94.9624, 12.0),
                CircleDataModel(28.51799, 111.0354, 12.0),
                CircleDataModel(56.13399, 28.9682, 12.0),
                CircleDataModel(48.50349, 11.5261, 12.0),
                CircleDataModel(34.56289, 0.3548, 12.0),
                CircleDataModel(38.17069, 27.5453, 12.0),
                CircleDataModel(35.22639, 44.9827, 12.0),
                CircleDataModel(55.04799, 198.3864, 12.0),
                CircleDataModel(34.12719, 84.2464, 12.0),
                CircleDataModel(55.88789, 179.9024, 12.0),
                CircleDataModel(56.84219, 161.4354, 12.0),
                CircleDataModel(43.50699, 149.4534, 12.0),
                CircleDataModel(59.07229, 141.0914, 12.0),
            )
            _circleState.value = circles
        }
    }
}
