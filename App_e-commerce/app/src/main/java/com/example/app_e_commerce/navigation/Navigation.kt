package com.example.app_e_commerce.navigation

import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.app_e_commerce.model.Screems
import com.example.app_e_commerce.views.HOMEPAGE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.app_e_commerce.views.Categories


@Composable
fun NavigationGraph(navHostController: NavHostController){
    NavHost(navController = navHostController,
        startDestination = Screems.HOMEPAGE.route) {
        composable(Screems.HOMEPAGE.route) {
            HOMEPAGE(navHostController)
        }
        composable(Screems.CATAGORIES.route) {
            Categories(navHostController)
        }
    }

}