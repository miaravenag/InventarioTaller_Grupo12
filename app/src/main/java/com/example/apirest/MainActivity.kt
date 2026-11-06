package com.example.apirest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apirest.ui.screens.PostScreen
import com.example.apirest.ui.theme.InventarioTaller_Grupo12Theme
import com.example.apirest.viewmodel.PostViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Permite que la app dibuje contenido debajo de las barras del sistema
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Aquí inicia Jetpack Compose
        setContent {
            InventarioTaller_Grupo12Theme {
                val postViewModel: PostViewModel = viewModel()
                PostScreen(viewModel = postViewModel)
            }
        }
    }
}
