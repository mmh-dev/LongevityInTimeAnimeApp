package com.mmh.longevityintimeanimeapp.presentation.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mmh.longevityintimeanimeapp.domain.model.Anime
import com.mmh.longevityintimeanimeapp.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnimeViewModel : ViewModel() {
    var animeList:List<Anime> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")

    fun getAnimesFromApi(page: Int, size: Int) {
        viewModelScope.launch (Dispatchers.IO) {
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
}