package com.example.carvandroidtaskarun.task1.presentation.view.state

import com.example.carvandroidtaskarun.task1.data.model.CircleDataModel

data class CarvUIState(
    var connectionStatus: Boolean? = null,
    var circles: List<CircleDataModel> = emptyList()
)