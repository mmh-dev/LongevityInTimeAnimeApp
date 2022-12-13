package com.mmh.longevityintimeanimeapp.presentation.ui.animeList

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mmh.longevityintimeanimeapp.presentation.components.AnimeCard
import com.mmh.longevityintimeanimeapp.presentation.ui.AnimeViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListScreen(navController: NavController, viewModel: AnimeViewModel) {
    val animeList = viewModel.animeList
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        content ={
            items(items = animeList) { anime ->
                AnimeCard(anime = anime)
            }
        })
}
