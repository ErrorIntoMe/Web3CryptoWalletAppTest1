package com.example.web3cryptowalletapp.data.web3

import android.util.Log
import com.dynamic.sdk.android.Chains.EVM.EthereumTransaction
import com.dynamic.sdk.android.Chains.EVM.convertEthToWei
import com.dynamic.sdk.android.DynamicSDK
import com.example.web3cryptowalletapp.data.auth.DynamicAuthDataSourceImpl
import com.example.web3cryptowalletapp.domain.model.TxResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.protocol.core.methods.response.EthSendTransaction
import org.web3j.protocol.http.HttpService
import org.web3j.utils.Convert
import java.math.BigDecimal
import java.math.BigInteger

class Web3RepositoryImpl : Web3Repository {
    private val web3: Web3j by lazy {
        Web3j.build(HttpService(Web3Config.RPC_URL))
    }
    override suspend fun getBalanceEth(address: String): String = withContext(Dispatchers.IO) {

        try {
            val response = web3.ethGetBalance(
                address,
                DefaultBlockParameterName.LATEST
            ).send()

            val balanceWei = response.balance
            val eth = Convert.fromWei(balanceWei.toString(), Convert.Unit.ETHER).toPlainString()

            Log.d("getBalanceEth", "balanceWei=$balanceWei eth=$eth")
            eth
        } catch (e: Exception) {
            Log.e("getBalanceEth", "Error getting balance: ${e.message}", e)
            "0"
        }
    }

}


object Web3Config {
    const val CHAIN_ID: Long = 11155111L
    const val RPC_URL = "https://eth-sepolia.g.alchemy.com/v2/rzkXqLtJ52FpQPUcVYP_8"

}