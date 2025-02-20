package com.example.app_e_commerce.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.app_e_commerce.R
import com.example.app_e_commerce.model.Screems


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
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(8.dp)
        ) {
                AppContent()
        }
    }
}
@Composable
fun AppContent() {
    var selectedCategory by remember { mutableStateOf(categories.first()) }

    Row(modifier = Modifier.fillMaxSize()) {
        // Menu bên trái
        MenuSidebar(selectedCategory,
            onCategorySelected={category ->
                selectedCategory = category},
            modifier=Modifier.weight(1f))

        // Nội dung bên phải
        ContentScreen(selectedCategory,Modifier.weight(3f))
    }
}

@Composable
fun MenuSidebar(selectedCategory: String, onCategorySelected: (String) -> Unit,modifier:Modifier) {
    Column(
        modifier = Modifier
            .width(150.dp)
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        Text("Categories", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp))
        LazyColumn {
            items(categories) { category ->
                Box(

                ) {
                    Column(){
                        Text(
                            text = category,
                            fontSize = 16.sp,
                            fontWeight = if (category == selectedCategory)
                                FontWeight.Bold else FontWeight.Normal,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onCategorySelected(category) }
                                .padding(8.dp)
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun ContentScreen(category: String,modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("$category", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow {
            items(getProducts(category)) { product ->
                ProductItem(product)
            }
        }
    }
}

@Composable
fun ProductItem(product: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(120.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(product, fontSize = 14.sp)
        }
    }
}

val categories = listOf(
    "Kệ phòng tắm", "Sắp xếp không gian", "Sắp xếp đồ nhà bếp",
    "Loa Bluetooth", "Tai nghe không dây", "Đồng hồ thông minh",
    "Micro", "Điện thoại di động", "Cáp & Dock sạc"
)

fun getProducts(category: String): List<String> {
    return List(5) { "$category Sản phẩm ${it + 1}" }
}
