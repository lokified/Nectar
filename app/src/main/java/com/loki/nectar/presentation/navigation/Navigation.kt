package com.loki.nectar.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.loki.nectar.presentation.explore.ExploreScreen
import com.loki.nectar.presentation.favorite.FavoriteScreen
import com.loki.nectar.presentation.onBoarding.OnBoardingScreen
import com.loki.nectar.presentation.signin.SignInScreen

@Composable
fun Navigation(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screens.OnBoardingScreen.route
    ) {


        composable(route = Screens.OnBoardingScreen.route) {
            OnBoardingScreen(
                openScreen = {
                    navController.navigate(Screens.Login.route)
                }
            )
        }

        composable(route = Screens.Login.route) {
            SignInScreen(
                onGoogleSignIn = {
                    navController.navigate(Screens.ShopScreen.route)
                },
                onFacebookSignIn = {
                    navController.navigate(Screens.ShopScreen.route)
                }
            )
        }

        composable(route = Screens.ShopScreen.route) {

        }

        composable(route = Screens.ExploreScreen.route) {
            ExploreScreen()
        }

        composable(route = Screens.CartScreen.route) {

        }

        composable(route = Screens.FavoriteScreen.route) {
            FavoriteScreen()
        }

        composable(route = Screens.AccountScreen.route) {

        }
    }
}