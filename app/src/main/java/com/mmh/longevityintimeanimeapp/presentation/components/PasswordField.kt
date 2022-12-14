package com.mmh.longevityintimeanimeapp.presentation.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun PasswordField(value: String,  onNewValue: (String) -> Unit) {
    OutlinedTextField(
        singleLine = true,
        value = value,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = { onNewValue(it) },
        placeholder = { Text("Password") }
    )
}