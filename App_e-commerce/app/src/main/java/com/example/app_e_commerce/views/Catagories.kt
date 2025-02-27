package com.example.app_e_commerce.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
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
    val defaultCategories= categories.firstOrNull()?:"No Category"
    var selectedCategory by remember { mutableStateOf(defaultCategories) }
    val categoryImages= listOf(
        R.drawable.personicon, R.drawable.martphone,R.drawable.icondaysac,
        R.drawable.icontulanh,R.drawable.iconson,R.drawable.icongaubong2,
        R.drawable.carticon, R.drawable.iconsofa,R.drawable.iconhinhvay,
        R.drawable.iconaosomi,R.drawable.icondongho,R.drawable.iconbongda,
        R.drawable.iconoto,R.drawable.iconvocher)

    Row(modifier = Modifier.fillMaxSize()) {
        // Menu bên trái

       Column() {
           MenuSidebar(selectedCategory,
            onCategorySelected={category ->
                selectedCategory = category},
            modifier=Modifier.weight(1f),
            categoryImages=categoryImages)}

      ContentScreen(selectedCategory, modifier = Modifier.weight(4f))
    }
}

@Composable
fun MenuSidebar(
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier,
    categoryImages: List<Int> // Nhận danh sách ảnh làm tham số
) {
    Column(
        modifier = modifier
            .width(140.dp)
            .background(Color.LightGray)
            .padding(4.dp)
    ) {
        Text("Categories",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp))

        LazyColumn {
            itemsIndexed(categories) { index, category ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCategorySelected(category) }
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // Hiển thị hình ảnh tương ứng với danh mục
                    Image(
                        painter = painterResource(id = categoryImages[index]),
                        contentDescription = category,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = category,
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontWeight = if (category == selectedCategory)
                        FontWeight.Bold else FontWeight.Normal,
                        color = if (category == selectedCategory)
                        Color.Red else Color.Black
                    )
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
        Text("$category", fontSize = 22.sp,
            fontWeight = FontWeight.Bold, color = Color.Red)
        Spacer(modifier = Modifier.padding(5.dp))
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
        Box(contentAlignment = Alignment.Center) {
            Text(product, fontSize = 14.sp)
        }
    }
}

val categories = listOf(
    "Dành cho bạn", "Thiết bị điện tử", "Phụ kiện điện tử",
    "Tv và Điện gia dụng", "Sức khỏe và làm đẹp", "Hàng củ mẹ và bé",
    "Siêu thị tạp hóa", "gia dụng và đời sống", "thời trang và phụ kiện nữ",
    "thời trang và phụ kiện nam", "thời trang và phụ kiện trẻ","Thể thao và du lịch",
    "Ô tô , xe máy thiết bị đinh vị","Vocher và dịch vụ"
)

fun getProducts(category: String): List<String> {
    return List(5) { "$category Sản phẩm ${it + 1}" }
}
