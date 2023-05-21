package com.loki.nectar.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loki.nectar.R

@Composable
fun FavoriteItem(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    title: String,
    amount: String,
    price: String
) {

    Box(modifier = modifier) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 24.dp)
        ) {

            Image(
                painter = painterResource(id = image),
                contentDescription = "$title image",
                modifier = Modifier.size(45.dp)
            )

            Spacer(modifier = Modifier.weight(.2f))

            Column {

                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF181725)
                )

                Text(
                    text = "$amount, Price",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF7C7C7C)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "$$price",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF181725)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Image(
                painter = painterResource(id = R.drawable.forward),
                contentDescription = "$title image",
                modifier = Modifier.size(13.dp)
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            thickness = 1.dp,
            color = Color(0xFFE2E2E2)
        )
    }
}