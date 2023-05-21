package com.loki.nectar.presentation.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.loki.nectar.R
import com.loki.nectar.presentation.components.ProductItem
import com.loki.nectar.presentation.components.TopBar

@Composable
fun ExploreScreen() {

    Scaffold( topBar = { TopBar(title = "Find Products") }) { padding ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(padding)
        ) {


            SearchSection(
                modifier = Modifier.padding(16.dp),
                onSearch = {}
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(
                    horizontal = 8.dp
                ),
                modifier = Modifier.padding(
                    bottom = 80.dp
                )
            ) {

                items(products) { product ->

                    ProductItem(
                        image = product.image,
                        title = product.name,
                        backgroundColor = product.color,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSection(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit
) {

    var searchTerm by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(5.dp),
                color = Color(0xFFF2F3F2)
            )
    ) {
        TextField(
            value = searchTerm,
            onValueChange = {
                searchTerm = it
                onSearch(it)
            },
            placeholder = {
                Text(
                    text = "Search Store",
                    color = Color(0xFF7C7C7C)
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search icon",
                    modifier = Modifier.size(20.dp)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF2F3F2),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}