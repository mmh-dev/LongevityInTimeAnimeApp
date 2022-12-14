package com.mmh.longevityintimeanimeapp.presentation.ui

import android.graphics.drawable.Icon
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mmh.longevityintimeanimeapp.presentation.components.AnimeCard
import com.mmh.longevityintimeanimeapp.presentation.components.Screen
import com.mmh.longevityintimeanimeapp.presentation.theme.Main

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListScreen(navController: NavController, viewModel: AnimeViewModel) {
    val animeList = viewModel.animeList
    Column {
        TopAppBar() {
            TopAppBar(title = { Text(text = "Anime list")},
                elevation = 4.dp,
                backgroundColor =  Main,
                navigationIcon = {
                    IconButton(onClick = {
                        viewModel.signOut()
                        navController.navigate(Screen.LoginScreen.route)
                    }) {
                        Icon(imageVector = Icons.Default.ExitToApp, contentDescription = null)
                    }
                }
            )
        }

        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            content ={
                items(items = animeList) { anime ->
                    AnimeCard(anime = anime, onClick = { navController.navigate(Screen.DetailsScreen.withArgs(anime._id)) })
                }
            })
    }
}
