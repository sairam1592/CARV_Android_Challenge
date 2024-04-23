package com.example.carvandroidtaskarun.task1.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.carvandroidtaskarun.task1.presentation.view.compose.CircleScreenView
import com.example.carvandroidtaskarun.task1.presentation.view.state.CarvUIState
import com.example.carvandroidtaskarun.task1.presentation.viewmodel.CircleViewModel
import com.example.carvandroidtaskarun.task3.presentation.viewmodel.SensorConnectionViewModel
import com.example.carvandroidtaskarun.ui.theme.CarvAndroidTaskArunTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CircleActivity : ComponentActivity() {

    private val viewModel: CircleViewModel by viewModels()
    private val connectionViewModel: SensorConnectionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarvAndroidTaskArunTheme {
                val circles by viewModel.circleState.collectAsStateWithLifecycle()
                val connectionStatus by connectionViewModel.connectionStatus.collectAsStateWithLifecycle()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CircleScreenView(
                        carvUIState = CarvUIState(
                            connectionStatus = connectionStatus,
                            circles = circles
                        )
                    )
                }
            }
        }
    }
}
