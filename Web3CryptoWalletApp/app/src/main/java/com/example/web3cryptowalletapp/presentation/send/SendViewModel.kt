package com.example.web3cryptowalletapp.presentation.send

import android.net.Network
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dynamic.sdk.android.Chains.EVM.EthereumTransaction
import com.dynamic.sdk.android.Chains.EVM.convertEthToWei
import com.example.web3cryptowalletapp.data.auth.DynamicAuthDataSource
import com.example.web3cryptowalletapp.data.auth.DynamicAuthDataSourceImpl
import com.example.web3cryptowalletapp.data.web3.Web3Config
import com.example.web3cryptowalletapp.data.web3.Web3Repository
import com.example.web3cryptowalletapp.domain.model.TxResult
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
import kotlinx.serialization.json.intOrNull
import java.math.BigInteger


@HiltViewModel
class SendViewModel @Inject constructor(
    private val web3Repository: Web3Repository,
    private val dynamicAuthDataSource: DynamicAuthDataSource
) : ViewModel() {

    private val sdk = DynamicAuthDataSourceImpl.SDK

    private val _recipientAddress = MutableStateFlow("")
    val recipientAddress = _recipientAddress.asStateFlow()

    private val _amount = MutableStateFlow("")
    val amount = _amount.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _txHash = MutableStateFlow<String?>(null)
    val txHash = _txHash.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    fun onRecipientAddressChange(value: String) {
        _recipientAddress.value = value
    }

    fun onAmountChange(value: String) {
        _amount.value = value
    }


    fun isFormValid(): Boolean {
        return _recipientAddress.value.isNotEmpty() &&
                _amount.value.isNotEmpty() &&
                _amount.value.toDoubleOrNull() != null &&
                _recipientAddress.value.startsWith("0x")
    }

    fun sendTransaction() {
        val amountValue = _amount.value.replace(",", ".").toDoubleOrNull()
        Log.d("SendTxScreen", amountValue.toString())
        if (amountValue == null) {
            _error.value = "Invalid amount format"
            return
        }

        if (!_recipientAddress.value.startsWith("0x")) {
            _error.value = "Invalid recipient address format"
            return
        }

        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            _txHash.value = null
            try {
                val chainId = Web3Config.CHAIN_ID.toInt()
                val mainnetNetwork = com.dynamic.sdk.android.Models.Network(
                    JsonPrimitive(chainId))
                sdk.wallets.switchNetwork(
                    dynamicAuthDataSource.getWallet(),
                    mainnetNetwork)
                Log.d("SendTxScreen", "ChainId: $chainId")
                val client = sdk.evm.createPublicClient(chainId)
                val gasPrice = client.getGasPrice()
                Log.d("SendTxScreen", "gasPrice: $gasPrice")
                val maxFeePerGas = gasPrice * BigInteger.valueOf(2)
                val weiAmount = convertEthToWei(_amount.value)
                val transaction = EthereumTransaction(
                    from = dynamicAuthDataSource.getAddress(),
                    to = _recipientAddress.value,
                    value = weiAmount,
                    gas = BigInteger.valueOf(21000),
                    maxFeePerGas = maxFeePerGas,
                    maxPriorityFeePerGas = gasPrice
                )
                val txHash = sdk.evm.sendTransaction(
                    transaction,
                    dynamicAuthDataSource.getWallet()
                )
                _txHash.value = txHash
                Log.d("SendTxScreen", "TxHash: $txHash")
            } catch (e: Exception) {
                Log.e("SendTxScreen", "sendTransaction failed", e)
                _error.value = e.stackTraceToString()
            }
            _loading.value = false
        }
    }
}