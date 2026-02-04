package com.example.web3cryptowalletapp.domain.model

data class WalletInfo(
    val address: String,
    val chainId: Long,
    val balanceEth: String
)
