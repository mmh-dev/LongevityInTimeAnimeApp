package com.mmh.longevityintimeanimeapp.presentation.ui

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mmh.longevityintimeanimeapp.presentation.components.AnimeCard
import com.mmh.longevityintimeanimeapp.presentation.components.Screen
import com.mmh.longevityintimeanimeapp.presentation.theme.Main

@Preview
@Composable
fun ListScreen(navController: NavHostController = rememberNavController(), viewModel: AnimeViewModel = AnimeViewModel()) {

    val context = LocalContext.current
    val animeList = viewModel.animeList

    Column {
        TopAppBar() {
            TopAppBar(title = { Text(text = "Anime list")},
                elevation = 4.dp,
                backgroundColor =  Main,
                navigationIcon = {
                    IconButton(onClick = {
                        viewModel.signOut()
                        Toast.makeText( context,"See you soon!", Toast.LENGTH_SHORT).show()
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
