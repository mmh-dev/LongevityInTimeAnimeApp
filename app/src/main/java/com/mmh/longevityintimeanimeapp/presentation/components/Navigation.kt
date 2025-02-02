package com.mmh.longevityintimeanimeapp.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mmh.longevityintimeanimeapp.presentation.ui.*

@Preview
@Composable
fun Navigation() {
    val animeViewModel: AnimeViewModel = viewModel()
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {

        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController, animeViewModel)
            animeViewModel.getAnimesFromApi(1,100)
        }

        composable(route = Screen.SignUpScreen.route) {
            SignUpScreen(navController = navController, animeViewModel)
        }

        composable(route = Screen.ListScreen.route) {
            ListScreen(navController = navController, viewModel = animeViewModel )
        }

        composable(
            route = Screen.DetailsScreen.route + "/{id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) { entry ->
            DetailsScreen(id = entry.arguments?.getString("id"), viewModel = animeViewModel)
        }
    }
}