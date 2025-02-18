package com.example.app_e_commerce.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.app_e_commerce.R
import com.example.app_e_commerce.model.Screems

// Data class for Category
data class Category(val name: String, val imageRes: Int)

// Sample categories
val categories = listOf(
    Category("Loa không dây & loa Bluetooth", R.drawable.personicon),
//    Category("Tai nghe nhét tai không dây", R.drawable.earphone),
//    Category("Đồng hồ thông minh", R.drawable.smartwatch),
//    Category("Micro", R.drawable.microphone),
//    Category("Điện thoại di động", R.drawable.smartphone),
//    Category("Cáp & Dock sạc", R.drawable.cable_dock),
//    Category("Áo thun nam", R.drawable.tshirt),
//    Category("Pin sạc dự phòng", R.drawable.powerbank),
//    Category("Camera IP kết nối Internet", R.drawable.camera)
)

@Composable
fun CategoryItem(category: Category) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { }
    ) {
        Image(
            painter = painterResource(id = category.imageRes),
            contentDescription = category.name,
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = category.name, fontSize = 18.sp, fontWeight = FontWeight.Medium)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Categories(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Categories",
                        modifier = Modifier.padding(2.dp),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.navigate(Screems.HOMEPAGE.route) }) {
                        Icon(
                            Icons.Default.ArrowBackIosNew,
                            contentDescription = null,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Search, contentDescription = "Search")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(categories) { category ->
                CategoryItem(category)
            }
        }
    }
}
