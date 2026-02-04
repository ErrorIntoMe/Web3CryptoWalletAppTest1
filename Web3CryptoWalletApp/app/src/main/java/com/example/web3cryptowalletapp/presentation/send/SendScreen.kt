package com.example.web3cryptowalletapp.presentation.send

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.web3cryptowalletapp.components.ErrorMessageView
import com.example.web3cryptowalletapp.components.InfoCard
import com.example.web3cryptowalletapp.components.PrimaryButton
import com.example.web3cryptowalletapp.components.ScreenRoot
import com.example.web3cryptowalletapp.components.SoftCard
import com.example.web3cryptowalletapp.components.SuccessMessageView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendTxScreen(
    vm: SendViewModel,
    onBack: () -> Unit,
    onSend: () -> Unit
) {
    val error by vm.error.collectAsState()
    val recipientAddress by vm.recipientAddress.collectAsState()
    val amount by vm.amount.collectAsState()
    val txHash by vm.txHash.collectAsState()
    val loading by vm.loading.collectAsState()
    val canSend = remember { mutableStateOf(vm.isFormValid()) }
    Log.d("SendTxScreen", "CanSend: $canSend")
    Scaffold(
        containerColor = Color(0xFFF6F7FB),
        topBar = {
            TopAppBar(
                title = { Text("Send Transaction", fontWeight = FontWeight.SemiBold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
            )
        }
    ) { padding ->
        ScreenRoot {
            Spacer(Modifier.height(padding.calculateTopPadding()))
            Spacer(Modifier.height(16.dp))

            SoftCard {
                Text("Recipient Address", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = recipientAddress,
                    onValueChange = { vm.onRecipientAddressChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("0x...") },
                    singleLine = true,
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.Black,
                        focusedTextColor = Color.Black,
                        focusedBorderColor = Color(0xFF2F80ED),
                        unfocusedBorderColor = Color(0xFFE5E7EB),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                Spacer(Modifier.height(14.dp))

                Text("Amount (ETH)", fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = amount,
                    onValueChange = { vm.onAmountChange(it) },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("0.01") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.Black,
                        focusedTextColor = Color.Black,
                        focusedBorderColor = Color(0xFF2F80ED),
                        unfocusedBorderColor = Color(0xFFE5E7EB),
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    )
                )

                Spacer(Modifier.height(14.dp))

                Text(
                    text = "Tip: Make sure you are on the correct network.",
                    fontSize = 12.sp,
                    color = Color(0xFF6B7280)
                )
            }

            Spacer(Modifier.height(16.dp))

            error?.let { error ->
                ErrorMessageView(message = error)
                Spacer(modifier = Modifier.height(8.dp))
            }

            PrimaryButton(
                title = "Send",
                isLoading = loading,
                onClick = {
                    onSend()
                }
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = "You may need to confirm in your wallet provider.",
                fontSize = 12.sp,
                color = Color(0xFF6B7280)
            )

            Spacer(Modifier.height(10.dp))

            txHash?.let { txHash ->
                InfoCard(
                    title = "Transaction Hash",
                    content = txHash
                )
                Spacer(modifier = Modifier.height(8.dp))
                SuccessMessageView(message = "Transaction sent successfully!")
            }
            Log.d("SuccessMessageView", txHash.toString())


        }
    }


}

