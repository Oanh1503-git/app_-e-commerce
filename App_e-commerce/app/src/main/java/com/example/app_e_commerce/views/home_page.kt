package com.example.app_e_commerce.views

import android.provider.Settings.Panel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddHome
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SavedSearch
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.app_e_commerce.R
import com.example.app_e_commerce.model.BottomNavItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HOMEPAGE(navController: NavHostController) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = "")},
                actions = {
                       SeachFiled()
                }
        )
        },
        bottomBar = {
            contentColorFor(backgroundColor = Color.White)
            BottomAppBar {
                MenuBottomNavBar(navController)
            }
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)
            .padding(10.dp)
            .fillMaxSize()) {
           item{
               ImageSlider()
           }
            item {
                Text(text = "Dành riêng cho bạn")
            }
        }
    }
}
@Composable
fun SeachFiled(){   
    var text by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.padding(4.dp).border(2.dp,
            color = Color.Red, RoundedCornerShape(25.dp))
    ){
        OutlinedTextField(
            value = text,
            onValueChange = {text=it},
            leadingIcon ={
                Icon(Icons.Default.SavedSearch,
                    contentDescription = "seach_tapbar")
            },
            placeholder = { Text(text = " Tìm kiếm ")},
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Button(onClick = {},
                    modifier = Modifier.padding(6.dp)
                        , colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        )
                    ){
                    Text(text="SEACH",
                        color = Color.White,
                        textAlign = TextAlign.Center)
                }
            },
            shape = RoundedCornerShape(25.dp)
            )
    }
}
@Composable
fun MenuBottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Home", Icons.Default.Home, "home_page"),
        BottomNavItem("Categories", Icons.Default.List, "catagories"),
        BottomNavItem("Cart", Icons.Default.ShoppingCart, "cart"),
        BottomNavItem("Account", Icons.Default.Person, "account")
    )

    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar(containerColor = Color.White) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            modifier = Modifier.size(24.dp),
                            tint = if (selectedItem == index) Color.Black else Color.Gray
                        )
                    }
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                        color = if (selectedItem == index) Color.Black else Color.Gray
                    )
                },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route) {
                        popUpTo("home") { inclusive = false }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
@Composable
fun ImageSlider() {
    val images = listOf(
        R.drawable.bannergiay,
        R.drawable.banner2,
        R.drawable.banner3
    )

    val pagerState = rememberPagerState(pageCount = { images.size })

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        ) { page ->
            Image(
                painter = painterResource(id = images[page]),
                contentDescription = "Banner $page",
                modifier = Modifier.fillMaxSize().padding(8.dp),
                contentScale = ContentScale.Crop
            )
        }

    }
    // Tự động cuộn ảnh sau mỗi 3 giây
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000) // 3 giây đổi ảnh
            val nextPage = (pagerState.currentPage + 1) % images.size
            pagerState.animateScrollToPage(nextPage)
        }
    }
}
