package com.example.firstkmpproject.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.AppResult
import core.SharedFactory
import domain.ScreenConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    private val api = SharedFactory().createSharedApi()
    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            when (val result = api.loadScreen()) {
                is AppResult.Error -> {
                    _state.value = UiState.Error(result.error.message ?: "Error")
                }

                is AppResult.Success -> {
                    _state.value = UiState.Success(result.value.title, result.value.message)
                }
            }
        }

    }
}