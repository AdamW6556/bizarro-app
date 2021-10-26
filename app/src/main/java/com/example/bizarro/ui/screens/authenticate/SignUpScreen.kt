package com.example.bizarro.ui.screens.authenticate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bizarro.ui.Screen

@Composable
fun SignUpScreen(navController: NavController)
{

    Column(

        modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally) {


        Spacer(modifier = Modifier.height(100.dp))


        Text("Sign Up to Bizarro!",
            style = TextStyle(
                fontSize = 32.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            ))

        Spacer(modifier = Modifier.height(80.dp))

        var textRegisterEmail by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value =textRegisterEmail,
            onValueChange ={
                textRegisterEmail = it
            },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Type your e-mail") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = "EmailIcon" )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Black)
        )

        Spacer(modifier = Modifier.height(20.dp))

        var textRegisterPassword by remember { mutableStateOf(TextFieldValue("")) }


        OutlinedTextField(
            value = textRegisterPassword,
            onValueChange ={
                textRegisterPassword = it
            },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Type your password") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "PasswordIcon" )
            }
        )

        Spacer(modifier = Modifier.height(80.dp))

        Button(
            onClick ={
                navController.navigate(route = com.example.bizarro.ui.Screen.SignIn.route)

            },
            Modifier.size(width = 250.dp, height = 50.dp),
        )
        {
            Text(text = "Register Account",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            )

        }
    }

}