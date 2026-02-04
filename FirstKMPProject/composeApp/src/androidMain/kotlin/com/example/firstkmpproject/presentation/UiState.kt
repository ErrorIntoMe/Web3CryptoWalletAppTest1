package com.example.firstkmpproject.presentation

import android.os.Message

sealed class UiState {
    data object Loading: UiState()
    data class Success(val title: String, val message: String): UiState()
    data class Error(val message: String): UiState()
}