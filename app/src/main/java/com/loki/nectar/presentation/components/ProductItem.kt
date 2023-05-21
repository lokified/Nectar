package com.loki.nectar.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    title: String,
    backgroundColor: Color
) {

    Box(
        modifier = modifier
            .background(
                color = backgroundColor.copy(0.25f),
                shape = RoundedCornerShape(18.dp)
            )
            .border(
                width = 1.dp,
                color = backgroundColor,
                shape = RoundedCornerShape(18.dp)
            )
            .size(
                height = 190.dp,
                width = 175.dp
            )
            .padding(16.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = image),
                contentDescription = "$title image",
                modifier = Modifier
                    .size(100.dp)
            )

            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }
}