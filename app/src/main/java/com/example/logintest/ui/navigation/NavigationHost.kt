package com.example.logintest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.logintest.ui.screens.*


@Composable
fun NavigationHost() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destinations.Login.route) {
        composable(Destinations.Login.route) {
            SignInScreen(navController)
        }
        composable(Destinations.Screen1.route) {
            Screen1(navController)
        }
    }
}