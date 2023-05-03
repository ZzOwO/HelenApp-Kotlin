package com.example.logintest.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings

sealed class Destinations (
    val route: String

    ){

    object Login: Destinations("login")
    object Screen1: Destinations("screen1")
    object Screen2: Destinations("screen2")
}

