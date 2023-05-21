package com.loki.nectar.presentation.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loki.nectar.presentation.components.FavoriteItem
import com.loki.nectar.presentation.components.TopBar
import com.loki.nectar.ui.theme.primary_green

@Composable
fun FavoriteScreen() {

    Scaffold(
        topBar = {
            TopBar(
                title = "Favorite",
                elevation = true
            )
        }
    ) { padding ->

        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                bottom = 170.dp
            ),
            modifier = Modifier.padding(padding)
        ) {

            items(favorites) { favorite ->

                FavoriteItem(
                    image = favorite.image,
                    title = favorite.name,
                    amount = favorite.amount,
                    price = favorite.price
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp)
        ) {

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(16.dp)
                    .align(Alignment.BottomCenter)
                    .alpha(1f),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primary_green,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Add All To Cart", fontSize = 18.sp)
            }
        }
    }
    
}