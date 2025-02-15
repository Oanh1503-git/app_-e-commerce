package com.example.app_e_commerce.views

import android.provider.Settings.Panel
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddHome
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.SavedSearch
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.app_e_commerce.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HOMEPAGE() {
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
               Row (){
                   ButtonHomeBottomBar()
                   ButtonCategoriesBottomBar()
                   ButtonCartBottomBar()
                   ButtonPersonIconBottomBar()
               }
            }
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            // Nội dung trang
        }
    }
}
@Composable
fun ButtonHomeBottomBar(){
    Button(onClick = {},
        modifier = Modifier.padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
        shape = RectangleShape) {
        Image(painter = painterResource(R.drawable.homepageicon),
            contentDescription = "homepage")
    }
}
@Composable
fun ButtonCategoriesBottomBar(){
    Button(onClick = {},
        modifier = Modifier.padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
        shape = RectangleShape){
        Image(painter = painterResource(R.drawable.categoriesicon),
            contentDescription = "categories_button")
    }
}
@Composable
fun ButtonCartBottomBar(){
        Button(onClick = {},
            modifier = Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
            shape = RectangleShape){
            Image(painter = painterResource(R.drawable.carticon),
                contentDescription = "categories_button")
        }
}
@Composable
fun ButtonPersonIconBottomBar(){

        Button(onClick = {},
            modifier = Modifier.padding(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp),
            shape = RectangleShape){
           Icon(Icons.Default.Person, contentDescription = "personIcon",
               Modifier.size(200.dp))

        }

}
@Composable
fun SeachFiled(){
    var text by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.padding(4.dp).border(2.dp,
            color = Color.Red, RoundedCornerShape(20.dp))
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
                    modifier = Modifier.padding(4.dp)
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
            shape = RoundedCornerShape(20.dp)
            )
    }
}