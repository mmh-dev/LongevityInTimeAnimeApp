package com.mmh.longevityintimeanimeapp.presentation.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun EmailField(value: String,  onNewValue: (String) -> Unit) {
    OutlinedTextField(
        singleLine = true,
        value = value,
        onValueChange = { onNewValue(it) },
        placeholder = { Text("Email") }
    )
}