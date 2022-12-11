package com.mmh.longevityintimeanimeapp.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mmh.longevityintimeanimeapp.presentation.ui.AnimeViewModel
import com.mmh.longevityintimeanimeapp.presentation.ui.animeDetails.DetailsScreen
import com.mmh.longevityintimeanimeapp.presentation.ui.animeList.ListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.ListScreen.route) {
        composable(route = Screen.ListScreen.route) {
            ListScreen(navController = navController, )
        }
        composable(
            route = Screen.DetailsScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "Murod default value"
                    nullable = true
                }
            )
        ) { entry ->
            DetailsScreen(name = entry.arguments?.getString("name"))
        }
    }
    AnimeCard(anime = )
    AnimeViewModel
}