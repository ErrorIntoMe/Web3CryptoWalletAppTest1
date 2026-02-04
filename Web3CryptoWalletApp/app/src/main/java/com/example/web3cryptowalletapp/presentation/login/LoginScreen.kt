package com.example.web3cryptowalletapp.presentation.login


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.dynamic.sdk.android.DynamicSDK
import com.example.web3cryptowalletapp.R
import com.example.web3cryptowalletapp.components.ErrorMessageView
import com.example.web3cryptowalletapp.components.OtpVerificationSheet
import com.example.web3cryptowalletapp.components.PrimaryButton
import kotlinx.coroutines.launch

@Composable
fun LoginScreenWithDesign(
    onLoggedIn: () -> Unit
) {
    val viewModel: LoginViewModel = androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel()
    val email by viewModel.email.collectAsState()
    val isSendingEmailOTP by viewModel.isSendingEmailOTP.collectAsState()
    val isEmailOtpSheetPresented by viewModel.isEmailOtpSheetPresented.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(60.dp))


        Icon(
            painter = painterResource(id = R.drawable.ethereum_crypto_cryptocurrency_svgrepo_com),
            contentDescription = "Logo",
            tint = Color(0xFF3B82F6),
            modifier = Modifier.size(72.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Crypto Wallet",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Please sign in to continue",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(36.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { viewModel.updateEmail(it) },
            label = { Text("Email") },
            placeholder = { Text("you@example.com") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(74.dp),
            shape = RoundedCornerShape(8.dp),
        )


        Spacer(modifier = Modifier.height(24.dp))

        PrimaryButton(
            title = "Send Email OTP",
            onClick = { viewModel.sendEmailOTP() },
            isLoading = isSendingEmailOTP,
            isDisabled = email.trim().isEmpty()
        )


    }

    if (isEmailOtpSheetPresented) {
        OtpVerificationSheet(
            title = "Email verification",
            subtitle = if (email.isEmpty()) null else "We sent a code to $email",
            onVerify = { code -> viewModel.verifyEmailOTP(code) },
            onResend = { viewModel.resendEmailOTP() },
            onDismiss = { viewModel.dismissEmailOtpSheet() },
            onLoggedIn = { onLoggedIn.invoke() }
        )
    }
}









