package com.example.web3cryptowalletapp.data.web3

import com.example.web3cryptowalletapp.domain.model.TxResult
import kotlinx.coroutines.flow.StateFlow
import java.math.BigInteger

interface Web3Repository {
    suspend fun getBalanceEth(address: String): String

}