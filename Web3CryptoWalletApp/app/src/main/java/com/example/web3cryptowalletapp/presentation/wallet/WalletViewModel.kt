package com.example.web3cryptowalletapp.presentation.wallet

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dynamic.sdk.android.Models.BaseWallet
import com.dynamic.sdk.android.Models.UserProfile
import com.example.web3cryptowalletapp.data.auth.DynamicAuthDataSource
import com.example.web3cryptowalletapp.data.auth.DynamicAuthDataSourceImpl
import com.example.web3cryptowalletapp.data.web3.Web3Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.intOrNull


@HiltViewModel
class WalletViewModel @Inject constructor(
    private val web3Repository: Web3Repository,
    private val dynamicAuthDataSource: DynamicAuthDataSource
) : ViewModel() {

    private val sdk = DynamicAuthDataSourceImpl.SDK




    private val _address = MutableStateFlow<String?>(null)
    val address = _address.asStateFlow()
    private val _network = MutableStateFlow<String?>(null)
    val network = _network.asStateFlow()
    private val _balance = MutableStateFlow<String?>(null)
    val balance = _balance.asStateFlow()
    private val _isLoadingNetwork = MutableStateFlow(false)
    val isLoadingNetwork = _isLoadingNetwork.asStateFlow()

    private val _isLoadingBalance = MutableStateFlow(false)
    val isLoadingBalance = _isLoadingBalance.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()


    fun showUserProfile() {
        sdk.ui.showUserProfile()
    }

    init {
        refresh()
    }

    private fun loadBalance() {
        viewModelScope.launch {
            _isLoadingBalance.value = true
            try {
                val address = dynamicAuthDataSource.getAddress()
                Log.d("Address", address)
                val balanceResult = web3Repository.getBalanceEth(address)
                Log.d("Balance", balanceResult)
                _address.emit(address)
                _balance.emit(balanceResult)
            } catch (e: Exception) {
                _balance.value = null
            }
            _isLoadingBalance.value = false
        }
    }


    private fun loadNetwork() {
        viewModelScope.launch {
            _isLoadingNetwork.value = true
            try {
                val networkResult = dynamicAuthDataSource.getNetwork()
                val jsonValue = networkResult.value
                _network.value = if (jsonValue is JsonPrimitive) {
                    jsonValue.intOrNull?.toString() ?: jsonValue.contentOrNull
                    ?: jsonValue.toString()
                } else {
                    jsonValue.toString()
                }
            } catch (e: Exception) {
                _network.value = null
            }
            _isLoadingNetwork.value = false
        }
    }


    fun refresh() {
        loadBalance()
        loadNetwork()
    }

    fun copy(textAddress: String?, context: Context) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("address", textAddress)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(context, "Скопировано", Toast.LENGTH_SHORT).show()
    }


    suspend fun logout(onDone: () -> Unit) {
        dynamicAuthDataSource.logout()
        onDone()
    }
}