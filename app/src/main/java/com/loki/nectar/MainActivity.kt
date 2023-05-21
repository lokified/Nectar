package com.loki.nectar

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.loki.nectar.presentation.components.BottomNav
import com.loki.nectar.presentation.navigation.Navigation
import com.loki.nectar.presentation.navigation.Screens
import com.loki.nectar.ui.theme.NectarTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            NectarTheme {

                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNav(
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route) {

                                    popUpTo(Screens.ShopScreen.route) {
                                        saveState = true
                                    }

                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                ) {

                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}