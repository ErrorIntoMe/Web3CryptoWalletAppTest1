package com.example.web3cryptowalletapp.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dynamic.sdk.android.DynamicSDK
import com.example.web3cryptowalletapp.data.auth.DynamicAuthDataSourceImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class SplashScreenViewModel : ViewModel() {
    private var didRoute = false
    private val _navigateTo = MutableStateFlow<String?>("")
    val navigateTo= _navigateTo.asStateFlow()
    fun start(
        onNavigateToLogin: () -> Unit,
        onNavigateToWallet: () -> Unit
    ) {
        if (didRoute) return

        val sdk = DynamicAuthDataSourceImpl.SDK

        viewModelScope.launch {

            sdk.sdk.readyChanges.first { it }

            if (didRoute) return@launch
            didRoute = true


            val token = sdk.auth.token ?: ""

            if (token.isNotEmpty()) {
                android.util.Log.d("SplashVM", "✅ SDK ready + token exists -> Home")
                onNavigateToWallet()
            } else {
                android.util.Log.d("SplashVM", "🔐 SDK ready + no token -> Login")
                onNavigateToLogin()
            }
        }
    }
}