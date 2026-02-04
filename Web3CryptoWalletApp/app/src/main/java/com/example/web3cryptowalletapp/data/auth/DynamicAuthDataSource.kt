package com.example.web3cryptowalletapp.data.auth

import com.dynamic.sdk.android.Models.BaseWallet
import com.dynamic.sdk.android.Models.Network
import com.dynamic.sdk.android.Models.UserProfile
import kotlinx.coroutines.flow.StateFlow

interface DynamicAuthDataSource {


    val tokenChanges: StateFlow<String?>
    val userChanges: StateFlow<UserProfile?>


   suspend fun getBalance(): String
    fun getWallet(): BaseWallet
    fun getAddress(): String
    suspend fun logout()
    fun showAuth()
    fun showUserProfile()

    suspend fun sendEmailOtp(trimmed: String)

    suspend fun verifyEmailOtp(trimmed: String)
    suspend fun resendEmailOtp()

    suspend fun getNetwork(): Network
}


sealed interface AuthResult {
    data class Success(
        val walletAddress: String,
        val chainId: Long?
    ) : AuthResult

    data class Error(val message: String) : AuthResult
}