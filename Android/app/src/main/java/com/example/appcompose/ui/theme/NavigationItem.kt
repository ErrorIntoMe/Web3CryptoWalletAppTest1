package com.example.appcompose.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.appcompose.R

sealed class NavigationItem(
    val label: Int,
    val icon: ImageVector
) {

    object Home: NavigationItem(
        label = R.string.home,
        icon = Icons.Outlined.Home)

    object Massages: NavigationItem(
        label = R.string.massages,
        icon = Icons.Outlined.MailOutline)

    object Photos: NavigationItem(
        label = R.string.AccountBox,
        icon = Icons.Outlined.AccountBox)


}