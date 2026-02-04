package com.example.web3cryptowalletapp.presentation.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.web3cryptowalletapp.presentation.MainActivity
import com.example.web3cryptowalletapp.presentation.login.LoginScreenWithDesign
import com.example.web3cryptowalletapp.presentation.send.SendTxScreen
import com.example.web3cryptowalletapp.presentation.send.SendViewModel
import com.example.web3cryptowalletapp.presentation.splash.SplashScreen
import com.example.web3cryptowalletapp.presentation.wallet.WalletScreen
import com.example.web3cryptowalletapp.presentation.wallet.WalletViewModel

sealed class Screen(val route: String) {
    data object Login : Screen("login")
    data object Wallet : Screen("wallet")
    data object SendTx : Screen("send_tx")

}


@Composable
fun CryptoAppNav(context: MainActivity, startDestination: String = "splash") {
    val navController = rememberNavController()
    NavHost(navController, startDestination = startDestination) {

        composable("splash") {
            SplashScreen(
                onNavigateToWallet =  {navController.navigate(Screen.Wallet.route)},
                onNavigateToLogin = {navController.navigate(Screen.Login.route)}
            )
        }
        composable(Screen.Login.route) {
            LoginScreenWithDesign {
                navController.navigate(Screen.Wallet.route) {
                    popUpTo(Screen.Login.route) { inclusive = true }
                }
            }
        }
        composable(Screen.Wallet.route) {
            val vm: WalletViewModel = hiltViewModel()
            WalletScreen(
                vm,
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Wallet.route) { inclusive = true }
                    }
                },
                onBack = { context.finish() },
                onCopy = { address -> vm.copy(address, context = context) },
                onSend = { navController.navigate(Screen.SendTx.route) }
            )
        }
        composable(Screen.SendTx.route) {
            val vm: SendViewModel = hiltViewModel()
            SendTxScreen(
                vm,
                onBack = {
                    navController.popBackStack()
                },
                onSend = { vm.sendTransaction() }

            )
        }
    }
}