package com.example.web3cryptowalletapp.presentation.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dynamic.sdk.android.DynamicSDK
import com.example.web3cryptowalletapp.data.auth.DynamicAuthDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authDataSource: DynamicAuthDataSource,
) : ViewModel() {

    private val TAG = "LoginViewModel"

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()
    private val _isSendingEmailOTP = MutableStateFlow(false)
    val isSendingEmailOTP: StateFlow<Boolean> = _isSendingEmailOTP.asStateFlow()
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()
    private val _isEmailOtpSheetPresented = MutableStateFlow(false)
    val isEmailOtpSheetPresented: StateFlow<Boolean> = _isEmailOtpSheetPresented.asStateFlow()

    fun dismissEmailOtpSheet() {
        Log.d(TAG, "dismissEmailOtpSheet called")
        _isEmailOtpSheetPresented.value = false
    }

    fun updateEmail(value: String) {
        Log.d(TAG, "updateEmail called with value: $value")
        _email.value = value
    }

    fun sendEmailOTP() {
        val trimmed = _email.value.trim()
        Log.d(TAG, "sendEmailOTP called with email: $trimmed")

        if (trimmed.isEmpty()) {
            Log.d(TAG, "Email is empty, aborting sendEmailOTP")
            return
        }

        _errorMessage.value = null
        _isSendingEmailOTP.value = true

        viewModelScope.launch {
            try {
                Log.d(TAG, "Attempting to send email OTP...")
                authDataSource.sendEmailOtp(trimmed)
                Log.d(TAG, "Email OTP sent successfully, showing OTP sheet")
                _isEmailOtpSheetPresented.value = true
            } catch (e: Exception) {
                Log.e(TAG, "Failed to send email OTP: ${e.message}", e)
                _errorMessage.value = "Failed to send email OTP: ${e.message}"
            }
            _isSendingEmailOTP.value = false
        }
    }

    suspend fun verifyEmailOTP(code: String) {
        val trimmed = code.trim()
        Log.d(TAG, "verifyEmailOTP called with code: $trimmed")
        if (trimmed.isEmpty()) {
            Log.d(TAG, "OTP code is empty, aborting verifyEmailOTP")
            return
        }
        try {
            authDataSource.verifyEmailOtp(trimmed)
            Log.d(TAG, "OTP verified successfully")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to verify OTP: ${e.message}", e)
            val userMessage = parseErrorMessage(e.message) ?: "Failed to verify OTP"

            _errorMessage.value = userMessage
        }
    }

    private fun parseErrorMessage(errorJson: String?): String? {
        if (errorJson == null) return null
        return try {
            val jsonObj = org.json.JSONObject(errorJson)
            jsonObj.optString("message", null)
        } catch (ex: Exception) {
            null
        }
    }

    suspend fun resendEmailOTP() {
        Log.d(TAG, "resendEmailOTP called")
        try {
            authDataSource.resendEmailOtp()
            Log.d(TAG, "Email OTP resent successfully")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to resend email OTP: ${e.message}", e)
            _errorMessage.value = "Failed to resend email OTP: ${e.message}"
        }
    }

    fun login() {
        Log.d(TAG, "login called - showing auth UI")
        authDataSource.showAuth()
    }
}



