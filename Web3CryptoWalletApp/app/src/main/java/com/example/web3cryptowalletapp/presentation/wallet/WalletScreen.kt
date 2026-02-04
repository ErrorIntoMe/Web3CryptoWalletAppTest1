package com.example.web3cryptowalletapp.presentation.wallet

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.web3cryptowalletapp.components.PrimaryButton
import com.example.web3cryptowalletapp.components.RefreshWalletButton
import com.example.web3cryptowalletapp.components.ScreenRoot
import com.example.web3cryptowalletapp.components.SecondaryRowButton
import com.example.web3cryptowalletapp.components.SoftCard
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WalletScreen(
    viewModel: WalletViewModel,
    onLogout: () -> Unit,
    onBack: () -> Unit,
    onCopy: (String?) -> Unit,
    onSend: () -> Unit
) {

    BackHandler(enabled = true) {
        onBack()
    }
    val address by viewModel.address.collectAsState()
    Log.d("WalletScreen", "AddressScreen: $address")
    val balance by viewModel.balance.collectAsState()
    balance?.let { Log.d("WalletScreen", "BalanceScreen: $it") }
    val network by viewModel.network.collectAsState()
    val isLoadingBalance by viewModel.isLoadingBalance.collectAsState()
    val isLoadingNetwork by viewModel.isLoadingNetwork.collectAsState()
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        viewModel.refresh()
    }
    Scaffold(
        containerColor = Color(0xFFF6F7FB),
        topBar = {
            TopAppBar(
                title = { Text("Wallet Details", fontWeight = FontWeight.SemiBold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                actions = {
                    RefreshWalletButton() {
                        scope.launch {
                            viewModel.refresh()
                        }
                    }
                }
            )
        }
    ) { padding ->
        ScreenRoot {
            Spacer(Modifier.height(padding.calculateTopPadding()))
            Spacer(Modifier.height(16.dp))
            SoftCard {

                if (isLoadingNetwork || isLoadingBalance) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        androidx.compose.foundation.layout.Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            CircularProgressIndicator()
                            Text(
                                text = "Loading...",
                                modifier = Modifier.padding(top = 24.dp)
                            )
                        }
                    }
                }
                AssistChip(
                    onClick = {},
                    label = { Text("EVM", fontWeight = FontWeight.SemiBold) },
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = Color(0xFFEAF2FF),
                        labelColor = Color(0xFF2F80ED)
                    ),
                    border = null
                )

                Spacer(Modifier.height(12.dp))

                Text("Address", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(6.dp))
                Surface(
                    color = Color(0xFFF3F4F6),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)
                ) {
                    address?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(10.dp),
                            fontSize = 12.sp,
                            color = Color(0xFF374151)
                        )
                    }
                }
                Spacer(Modifier.height(14.dp))
                Text("Current Network", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(4.dp))
                network?.let {
                    Text(
                        it,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2F80ED)
                    )
                }
                Spacer(Modifier.height(14.dp))

                Text("Balance", fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                Spacer(Modifier.height(4.dp))
                balance?.let {
                    Text(
                        it,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2F80ED)
                    )
                }
            }

            Spacer(Modifier.height(12.dp))

            SecondaryRowButton(
                text = "Copy Address",
                leading = {
                    Icon(
                        Icons.Default.ContentCopy,
                        contentDescription = null,
                        tint = Color(0xFF6B7280)
                    )
                },
                onClick = { onCopy(network) }
            )

            Spacer(Modifier.height(12.dp))

            PrimaryButton(
                title = "Send Transaction",
                onClick = onSend
            )

            Spacer(Modifier.height(12.dp))

            SecondaryRowButton(
                text = "Logout",
                leading = {
                    Icon(Icons.Default.Logout, contentDescription = null, tint = Color(0xFFEF4444))
                },
                textColor = Color(0xFFEF4444),
                onClick = {
                    scope.launch {
                        viewModel.logout(onLogout)
                    }
                }
            )
            Spacer(Modifier.height(12.dp))
            SecondaryRowButton(
                text = "Open BoottomSheet Wallet ",
                leading = {
                    Icon(
                        Icons.Default.Wallet,
                        contentDescription = null,
                        tint = Color(0xFF2F80ED)
                    )
                },
                textColor = Color(0xFF2F80ED),
                onClick = {
                    viewModel.showUserProfile()
                }
            )
        }
    }
}