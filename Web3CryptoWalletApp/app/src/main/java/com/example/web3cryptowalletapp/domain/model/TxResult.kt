package com.example.web3cryptowalletapp.domain.model

sealed class TxResult{
    data class Success(val txHash: String) : TxResult()
    data class Error(val message: String) : TxResult()
}
