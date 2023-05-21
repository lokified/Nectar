package com.loki.nectar.presentation.signin

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loki.nectar.R
import com.loki.nectar.ui.theme.dark_blue
import com.loki.nectar.ui.theme.light_blue
import com.simon.xmaterialccp.component.MaterialCountryCodePicker
import com.simon.xmaterialccp.data.ccpDefaultColors
import com.simon.xmaterialccp.data.utils.getDefaultLangCode
import com.simon.xmaterialccp.data.utils.getDefaultPhoneCode
import com.simon.xmaterialccp.data.utils.getLibCountries

@Composable
fun SignInScreen(
    onGoogleSignIn: () -> Unit = {},
    onFacebookSignIn: () -> Unit = {}
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Image(
            painter = painterResource(id = R.drawable.nectar),
            contentDescription = stringResource(R.string.top_pic),
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        Text(
            text = stringResource(R.string.get_your_groceries),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        val context = LocalContext.current
        var phoneCode by remember { mutableStateOf(getDefaultPhoneCode(context)) }
        val phoneNumber = rememberSaveable { mutableStateOf("") }
        var defaultLang by rememberSaveable { mutableStateOf(getDefaultLangCode(context)) }

        SignInInput(
            modifier = Modifier.padding(16.dp),
            phone = phoneNumber.value,
            defaultLang = defaultLang,
            onPhoneCodeChange = { phoneCode = it },
            onPhoneNumberChange = { phoneNumber.value = it },
            onDefaultLangChange = { defaultLang = it },
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(R.string.or_connect_with_social_media),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 24.dp)
                )

                ButtonSection(
                    title = stringResource(R.string.continue_with_google),
                    icon = R.drawable.google,
                    onClick = {
                        onGoogleSignIn()
                    },
                    backgroundColor = light_blue,
                    modifier = Modifier.padding(
                        top = 40.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
                )

                ButtonSection(
                    title = stringResource(R.string.continue_with_facebook),
                    icon = R.drawable.facebook,
                    onClick = { onFacebookSignIn() },
                    backgroundColor = dark_blue,
                    modifier = Modifier.padding(
                        vertical = 8.dp,
                        horizontal = 16.dp
                    )
                )
            }
        }
    }
}


@Composable
fun SignInInput(
    modifier: Modifier = Modifier,
    phone: String,
    defaultLang: String,
    onPhoneCodeChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onDefaultLangChange: (String) -> Unit,
    error: Boolean = false,
    errorMessage: String = ""
) {

    Column(
        modifier = modifier
    ) {

        MaterialCountryCodePicker(
            text = phone,
            onValueChange = { onPhoneNumberChange(it) },
            defaultCountry = getLibCountries().single { it.countryCode == defaultLang },
            pickedCountry = {
                onPhoneCodeChange(it.countryPhoneCode)
                onDefaultLangChange(it.countryCode)
            },
            colors = ccpDefaultColors(
                backgroundColor = Color.Transparent,
                textColor = MaterialTheme.colorScheme.onBackground,
                outlineColor = Color.Transparent,
                unfocusedOutlineColor = Color.Transparent
            )
        )
        Divider(
            thickness = 1.dp,
            color = if (error) MaterialTheme.colorScheme.error else Color(0xFFE2E2E2),
            modifier = Modifier.fillMaxWidth()
        )

        if (error) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonSection(
    modifier: Modifier = Modifier,
    title: String,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
) {

    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(65.dp)
        ) {

            Image(
                painter = painterResource(id = icon),
                contentDescription = "$title icon",
                modifier = Modifier
                    .size(45.dp)
                    .align(Alignment.CenterStart)
                    .padding(start = 32.dp)
            )

            Text(
                text = title,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}