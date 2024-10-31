package com.flower.whereismystuff.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier) {
    var queryText by remember { mutableStateOf("") }
    var searchBarActive by remember { mutableStateOf(false) }
    var showTakePhoto by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        when(showTakePhoto) {
            true -> {
                CameraScreen()
            }
            false -> {
                SearchBar(
                    query = queryText,
                    onQueryChange = {
                        queryText = it
                    },
                    onSearch = { searchBarActive = false },
                    active = searchBarActive,
                    onActiveChange = {
                        searchBarActive = it
                    }
                ) { }
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = { showTakePhoto = true }) {
                    Text(text = "Add New")
                }
            }
        }
    }
}