package com.example.app_e_commerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.app_e_commerce.navigation.NavigationGraph
import com.example.app_e_commerce.ui.theme.App_ecommerceTheme
import com.example.app_e_commerce.views.Categories
import androidx.navigation.compose.rememberNavController
import com.example.app_e_commerce.views.HOMEPAGE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var navController: NavHostController
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_ecommerceTheme {
                navController= rememberNavController()
                NavigationGraph(navController)
            }
        }
    }
}

