package com.loki.nectar.presentation.navigation

sealed class Screens(val route: String) {

    object OnBoardingScreen: Screens("onboarding_screen")
    object Login: Screens("login_screen")
    object ShopScreen: Screens("shop_screen")
    object ExploreScreen: Screens("explore_screen")
    object CartScreen: Screens("cart_screen")
    object FavoriteScreen: Screens("favorite_screen")
    object AccountScreen: Screens("account_screen")
}