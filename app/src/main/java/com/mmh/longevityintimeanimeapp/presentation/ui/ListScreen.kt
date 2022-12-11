package com.mmh.longevityintimeanimeapp.presentation.ui.animeList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mmh.longevityintimeanimeapp.domain.model.Anime
import com.mmh.longevityintimeanimeapp.presentation.components.AnimeCard
import com.mmh.longevityintimeanimeapp.presentation.components.Screen

@Composable
fun ListScreen(navController: NavController, list: List<Anime>) {
    LazyColumn{
        itemsIndexed(items = list) {index, anime ->
            AnimeCard(anime = anime)
        }
    }
}
