package com.example.firstkmpproject.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewModel)
        }
    }
}


@Composable
fun MainScreen(viewModel: MainViewModel) {
    val state = viewModel.state.collectAsState()
    Column(Modifier.padding(16.dp)) {
        Text((state as UiState.Success).title ?: "Title is null")
        Spacer(Modifier.height(8.dp))
        Text((state as UiState.Success).message ?: "Message is null")
    }
}