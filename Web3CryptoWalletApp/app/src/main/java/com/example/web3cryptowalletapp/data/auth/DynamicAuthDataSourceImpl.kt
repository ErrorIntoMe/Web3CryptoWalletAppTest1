package com.example.web3cryptowalletapp.data.auth


import android.annotation.SuppressLint
import android.util.Log
import com.dynamic.sdk.android.DynamicSDK
import com.dynamic.sdk.android.Models.BaseWallet
import com.dynamic.sdk.android.Models.Network
import com.dynamic.sdk.android.Models.UserProfile
import dagger.hilt.android.scopes.ActivityScoped
import jakarta.inject.Inject
import kotlinx.coroutines.flow.StateFlow


class DynamicAuthDataSourceImpl  : DynamicAuthDataSource {
    override val tokenChanges: StateFlow<String?> = SDK.auth.tokenChanges
    override val userChanges: StateFlow<UserProfile?> = SDK.auth.authenticatedUserChanges

    override suspend fun getBalance(): String {
        return SDK.wallets.getBalance(getWallet())

    }

    override fun getWallet(): BaseWallet {
        return SDK.wallets.primary ?: throw Exception("No wallet")
    }

    override fun getAddress(): String {
        val address = SDK.wallets.primary?.address ?: ""
        Log.d("Address", address)
        return address

    }

    override suspend fun logout() {
        SDK.auth.logout()
    }

    override fun showAuth() {
        SDK.ui.showAuth()
    }

    override fun showUserProfile() {
        SDK.ui.showUserProfile()
    }

    override suspend fun sendEmailOtp(trimmed: String) {
        SDK.auth.email.sendOTP(trimmed)
    }

    override suspend fun verifyEmailOtp(trimmed: String) {
        SDK.auth.email.verifyOTP(trimmed)
    }

    override suspend fun resendEmailOtp(){
        SDK.auth.email.resendOTP()
    }

    override suspend fun getNetwork(): Network {
        return SDK.wallets.getNetwork(getWallet())
    }

    companion object{
        @SuppressLint("StaticFieldLeak")
        val SDK = DynamicSDK.getInstance()

    }
}


