package com.example.carvandroidtaskarun.task1.presentation.view.compose

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.carvandroidtaskarun.task1.data.model.CircleDataModel
import com.example.carvandroidtaskarun.task1.presentation.view.state.CarvUIState

@Composable
fun CircleScreenView(
    carvUIState: CarvUIState
) {

    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
            Box(
                modifier = Modifier.weight(1f)
            ) {
                DynamicCirclesView(circles = carvUIState.circles)
            }

            Text(
                text = if (carvUIState.connectionStatus == true) "Sensor Connected" else "Sensor Disconnected",
                color = if (carvUIState.connectionStatus == true) Color.Green else Color.Red,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun DynamicCirclesView(circles: List<CircleDataModel>) {
    val density = LocalDensity.current
    Canvas(modifier = Modifier.fillMaxSize()) {
        circles.forEach { circleData ->
            val pixelRadius = with(density) { circleData.radius.dp.toPx() }
            val pixelX = with(density) { circleData.x.dp.toPx() }
            val pixelY = with(density) { circleData.y.dp.toPx() }

            drawCircle(
                color = Color.Blue, radius = pixelRadius, center = Offset(pixelX, pixelY)
            )
        }
    }
}
