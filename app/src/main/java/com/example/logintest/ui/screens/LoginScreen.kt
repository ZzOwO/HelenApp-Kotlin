package com.example.logintest.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.logintest.R
import com.example.logintest.ui.navigation.Destinations


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignInScreen(navController: NavController) {

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var isPasswordVisible by remember {
        mutableStateOf(false)
    }

    val isFormValid by derivedStateOf {
        username.isNotBlank() && password.length >= 7
    }

    Scaffold(backgroundColor = MaterialTheme.colors.primary) {
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
            Image(
                painter = painterResource(id = R.drawable.login_image),
                contentDescription = "Login",
                modifier = Modifier
                    .weight(1f)
                    .size(200.dp)
            )
            Card(
                Modifier
                    .weight(2f)
                    .padding(8.dp),
                shape = RoundedCornerShape(32.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(32.dp)
                    ) {
                        Text(text = "Bienvenido!", fontWeight = FontWeight.Bold, fontSize = 32.sp)
                        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                            Spacer(modifier = Modifier.weight(1f))
                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                value = username,
                                onValueChange = { username = it },
                                label = { Text(text = "Nombre de Usuario")},
                                singleLine = true,
                                trailingIcon = {
                                    if (username.isNotBlank())
                                        IconButton(onClick = { username = "" }) {
                                            Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                                        }
                                }
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                value = password,
                                onValueChange = { password = it },
                                label = { Text(text = "Contraseña")},
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,  imeAction = ImeAction.Done),
                                visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                                trailingIcon = {
                                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                                        Icon(
                                            imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                            contentDescription = "Contraseña")
                                    }
                                }
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = {},
                                enabled = isFormValid,
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp)

                            ) {

                                Text(text = "Iniciar Sesión")
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                TextButton(onClick = {navController.navigate(route = Destinations.Screen1.route)}) {
                                    Text(text = "Sing Up")
                                }
                                TextButton(onClick = {  }) {
                                    Text(text = "Forgot Password?", color = Color.Gray)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}