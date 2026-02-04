package com.example.web3cryptowalletapp.presentation

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dynamic.sdk.android.DynamicSDK
import com.dynamic.sdk.android.UI.DynamicUI
import com.dynamic.sdk.android.core.ClientProps
import com.dynamic.sdk.android.core.LoggerLevel
import com.example.web3cryptowalletapp.presentation.nav.CryptoAppNav
import com.example.web3cryptowalletapp.ui.theme.Web3CryptoWalletAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application()

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val props = ClientProps(
            environmentId = "fe0b17d4-9c99-442f-9e1d-34691876766d",
            appLogoUrl = "https://demo.dynamic.xyz/favicon-32x32.png",
            appName = "Crypto Wallet",
            redirectUrl ="dynamicandroiddemo://",
            appOrigin = "https://your.app",
            logLevel = LoggerLevel.DEBUG
        )
        val sdk = DynamicSDK.initialize(props, applicationContext, this)

        setContent {
            Web3CryptoWalletAppTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CryptoAppNav(context = this@MainActivity)
                        DynamicUI()
                    }
                }
            }

        }
    }
}

