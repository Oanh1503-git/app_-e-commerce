package com.example.app_e_commerce.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.app_e_commerce.R

@Composable
fun CardPruductInHome(){
    Column (modifier = Modifier.padding(4.dp).fillMaxWidth()){
        Image(painter = painterResource(R.drawable.banner2),
            contentDescription = "")
        Text(text = "Name Product")
        Text(text = "Price Prucduct")
     Row {    Icon(Icons.Default.Star,
         contentDescription = "")
     Text(text = "4.9") }
        Spacer(modifier = Modifier.padding(5.dp))
    }
}