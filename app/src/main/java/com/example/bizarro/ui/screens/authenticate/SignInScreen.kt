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
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bizarro.ui.screens.user_profile.SettingsEditUserProfileViewModel
import com.example.bizarro.ui.theme.darkColor
import com.example.bizarro.ui.theme.kWhite
import com.example.bizarro.ui.theme.lightblueColor


@Composable
fun SignInScreen(navController: NavController,
                 viewModel: SettingsEditUserProfileViewModel = hiltViewModel(),)
{
   Column(

      modifier = Modifier
         .fillMaxSize()
         .background(kWhite),
      horizontalAlignment = Alignment.CenterHorizontally
   ) {

      Spacer(modifier = Modifier.height(100.dp))


      Text("Welcome to Bizarro!",
         style = MaterialTheme.typography.caption)

      Spacer(modifier = Modifier.height(80.dp))


      var textLoginEmail by remember { mutableStateOf(TextFieldValue("")) }

      OutlinedTextField(
         value =textLoginEmail,
         onValueChange ={
            textLoginEmail = it
         },
         label = { Text(text = "Email") },
         placeholder = { Text(text = "Type your e-mail") },
         leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = "EmailIcon" )
         },
         colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = darkColor,
            unfocusedBorderColor = darkColor)
      )

      Spacer(modifier = Modifier.height(20.dp))

      var textLoginPassword by remember { mutableStateOf(TextFieldValue("")) }

      OutlinedTextField(
         value = textLoginPassword,
         onValueChange ={
            textLoginPassword = it
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
            navController.navigate(route = com.example.bizarro.ui.Screen.UserProfile.route)
         },
         Modifier.size(width = 250.dp, height = 50.dp),
         colors = ButtonDefaults.buttonColors(backgroundColor = darkColor),

         ) {
         Text(text = "Sign In",
            style = MaterialTheme.typography.button
         )

      }

      Spacer(modifier = Modifier.height(20.dp))

      Text("OR",
         style = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
         ))


      Spacer(modifier = Modifier.height(20.dp))

      Button(
         onClick ={
            navController.navigate(route = com.example.bizarro.ui.Screen.SignUp.route)

         },
         Modifier.size(width = 250.dp, height = 50.dp),
         colors = ButtonDefaults.buttonColors(backgroundColor = lightblueColor),
      )
      {
         Text(text = "Sign Up",
            style = MaterialTheme.typography.button
         )
      }
   }
}