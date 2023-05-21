package com.loki.nectar.presentation.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loki.nectar.R
import com.loki.nectar.ui.theme.NectarTheme
import com.loki.nectar.ui.theme.primary_green

@Composable
fun OnBoardingScreen(
    openScreen: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.board),
            contentDescription = stringResource(R.string.onboarding_picture),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 70.dp),
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.BottomCenter)
            ) {


                Image(
                    painter = painterResource(id = R.drawable.carrot),
                    contentDescription = stringResource(R.string.onboarding_image),
                    modifier = Modifier.size(50.dp)
                )

                Text(
                    text = stringResource(R.string.welcome_to_our_store),
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    lineHeight = 55.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Text(
                    text = stringResource(R.string.get_your_groceries_in_as_fast_as_one_hour),
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = {
                        openScreen()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primary_green,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = stringResource(R.string.get_started), fontSize = 18.sp)
                }
            }
        }
    }
}