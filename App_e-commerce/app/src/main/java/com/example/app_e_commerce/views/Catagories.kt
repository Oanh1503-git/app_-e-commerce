package com.example.app_e_commerce.views

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

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
                        textAlign = TextAlign.Right
                    )
                },
                navigationIcon = {  // Thêm phần này để hiển thị icon ở góc trái
                    IconButton(onClick = { /* Handle back action */ }) {
                        Icon(
                            Icons.Default.ArrowBackIosNew,
                            contentDescription = null,
                            modifier = Modifier.padding(5.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Search,
                            contentDescription = "")
                    }
                }
            )
        }
    ) { innerPadding ->
        Row (modifier = Modifier.padding(4.dp).fillMaxWidth()
            .padding(innerPadding)){
            LazyColumn (modifier = Modifier.padding(4.dp)
                .fillMaxSize()
                .weight(1f)){
                item { Text(text = "nn88") }

            }
            LazyColumn (modifier = Modifier.padding(4.dp)
                .fillMaxSize()
                .weight(3f)){
                item {
                    Row {
                        Text(text = "nnnnvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv")
                        Text(text = "nnnn")
                        Text(text = "nnnn")
                        Text(text = "nnnn")
                    }
                    }

            }
        }
    }
}
