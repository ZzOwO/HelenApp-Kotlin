package com.example.logintest.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.logintest.ui.navigation.Destinations

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Screen1(navController: NavController) {
    Scaffold() {
        ContentScreen(navController)
    }
}

@Composable
fun ContentScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sesión Iniciada Correctamente")
        Button(onClick = { navController.navigate(route = Destinations.Login.route) }) {
            Text(text = "Volver al Login")
        }
    }
}
