package com.mmh.longevityintimeanimeapp.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.ktx.Firebase
import com.mmh.longevityintimeanimeapp.presentation.components.EmailField
import com.mmh.longevityintimeanimeapp.presentation.components.PasswordField
import com.mmh.longevityintimeanimeapp.presentation.components.Screen
import com.mmh.longevityintimeanimeapp.presentation.theme.Main

@Composable
fun SignUpScreen(navController: NavController, viewModel: AnimeViewModel) {

    val uiState by viewModel.uiState

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Sign Up", style = TextStyle(fontSize = 40.sp))

        Spacer(modifier = Modifier.height(20.dp))
        EmailField(uiState.email, onNewValue = viewModel::onEmailChange)

        Spacer(modifier = Modifier.height(20.dp))
        PasswordField(value = uiState.password, onNewValue = viewModel::onPasswordChange )

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = { sigIn(navController) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Main),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp
                    ))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            Text(text = "Already a user?", style = TextStyle(fontSize = 16.sp))
            Spacer(modifier = Modifier.width(20.dp))
            ClickableText(
                text = AnnotatedString("Sign in here"),
                onClick = { navController.navigate(Screen.LoginScreen.route) },
                style = TextStyle(
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
    }
}

fun sigUp(navController: NavController) {



    navController.navigate(Screen.ListScreen.route)
}
