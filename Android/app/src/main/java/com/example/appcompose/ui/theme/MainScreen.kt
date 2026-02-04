package com.example.appcompose.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(viewModel: MainViewModel) {
    val isFollowing = viewModel.isFollowing.observeAsState(false)
    val snackBarHostState = SnackbarHostState()
    val snackBarCoroutine = rememberCoroutineScope()
    val fbaState = remember { mutableStateOf(true) }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState) {
            }
        },
        floatingActionButton = {
            if (fbaState.value) {
                FloatingActionButton(onClick = {
                    viewModel.changeFollow()
                    snackBarCoroutine.launch {
                        val action = snackBarHostState.showSnackbar(
                            message = "This is snack bar",
                            actionLabel = "Hide FBA",
                            duration = SnackbarDuration.Long
                        )
                        if (action == SnackbarResult.ActionPerformed) {
                            fbaState.value = false
                        }
                    }
                }) {
                    val icon = if (isFollowing.value) {
                        Icons.Filled.Check
                    } else {
                        Icons.Filled.Favorite
                    }
                    Icon(icon, contentDescription = null)

                }
            }

        },
        bottomBar = {
            BottomAppBar() {
                val items = mutableListOf(
                    NavigationItem.Home,
                    NavigationItem.Massages,
                    NavigationItem.Photos
                )
                val stateOfPosition = remember { mutableStateOf(0) }
                NavigationBar() {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = stateOfPosition.value == index,
                            onClick = { stateOfPosition.value = index },
                            icon = { Icon(item.icon, contentDescription = null) },
                            label = { Text(text = stringResource(item.label)) }
                        )
                    }

                }
            }
        },
        topBar = {
            TopAppBar(
                title = { Text("TopAppBar") },
                navigationIcon = {
                    IconButton(onClick = { TODO() })
                    {
                        Icon(
                            Icons.Filled.Menu,
                            contentDescription = null,
                        )
                    }
                })
        },

        ) {

    }

}


@Composable
fun ClickButton(isFollowing: Boolean, callback: () -> Unit) {
    Button(
        onClick = { callback() },
    ) {
        val text = if (isFollowing) {
            "Unfollow"
        } else {
            "Follow"
        }
        Text(text)
    }
}

