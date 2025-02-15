package com.example.app_e_commerce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.app_e_commerce.ui.theme.App_ecommerceTheme
import com.example.app_e_commerce.views.HOMEPAGE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_ecommerceTheme {
              HOMEPAGE()
            }
        }
    }
}

