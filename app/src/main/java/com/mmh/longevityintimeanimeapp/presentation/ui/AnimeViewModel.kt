package com.mmh.longevityintimeanimeapp.presentation.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseUser
import com.mmh.longevityintimeanimeapp.domain.impl.AccountServiceImpl
import com.mmh.longevityintimeanimeapp.domain.model.Anime
import com.mmh.longevityintimeanimeapp.domain.model.LoginUiState
import com.mmh.longevityintimeanimeapp.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimeViewModel : ViewModel() {
    var authState = mutableStateOf(false)
    var user: FirebaseUser? = null
    var animeList: List<Anime> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    var uiState = mutableStateOf(LoginUiState())
        private set

    private val accountService = AccountServiceImpl()

    fun getAnimesFromApi(page: Int, size: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = RetrofitBuilder.api.getAnimes(page = page.toString(), size = size.toString())
                if (result.isSuccessful) {
                    animeList = result.body()?.data ?: mutableListOf()
                }
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }

        }
    }

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

    fun createUser(email: String, password: String) {
        accountService.createAccount(email = email, password = password) { error ->
            if (error == null) {
             authState.value = true
            }
        }
    }

    fun login(email: String, password: String) {
        accountService.authenticate(email = email, password = password) { error ->
            if (error == null) {
                authState.value = true
            }
        }
    }

    fun signOut() {
        authState.value = false
        accountService.signOut()
    }

}