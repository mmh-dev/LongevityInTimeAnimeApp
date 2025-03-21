package com.mmh.longevityintimeanimeapp.presentation.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mmh.longevityintimeanimeapp.presentation.components.EmailField
import com.mmh.longevityintimeanimeapp.presentation.components.PasswordField
import com.mmh.longevityintimeanimeapp.presentation.components.Screen
import com.mmh.longevityintimeanimeapp.presentation.theme.Main
@Preview
@Composable
fun LoginScreen(navController: NavHostController = rememberNavController(), viewModel: AnimeViewModel = AnimeViewModel()) {

    val uiState by viewModel.uiState
    val context = LocalContext.current

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Login", style = TextStyle(fontSize = 40.sp))

        Spacer(modifier = Modifier.height(20.dp))
        EmailField(uiState.email, onNewValue = viewModel::onEmailChange)

        Spacer(modifier = Modifier.height(20.dp))
        PasswordField(value = uiState.password, onNewValue = viewModel::onPasswordChange )

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = { sigIn(navController, uiState.email, uiState.password, viewModel, context) },
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
            Text(text = "No account yet?", style = TextStyle(fontSize = 16.sp))
            Spacer(modifier = Modifier.width(20.dp))
            ClickableText(
                text = AnnotatedString("Sign up here"),
                onClick = { navController.navigate(Screen.SignUpScreen.route) },
                style = TextStyle(
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
    }
}

fun sigIn(navController: NavController, email: String, password: String, viewModel: AnimeViewModel, context: Context) {
    if (email.isNotEmpty() && password.isNotEmpty()) {
        viewModel.login(email, password)
        if (viewModel.authState.value) {
            Toast.makeText( context,"Welcome back!", Toast.LENGTH_SHORT).show()
            navController.navigate(Screen.ListScreen.route)
        }
    } else {
        Toast.makeText( context,"Please, fill in email and password fields!", Toast.LENGTH_SHORT).show()
    }

}
