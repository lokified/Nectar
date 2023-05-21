package com.loki.nectar.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.loki.nectar.R
import com.loki.nectar.presentation.navigation.Screens
import com.loki.nectar.ui.theme.primary_green

@Composable
fun BottomNav(
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit = {}
) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    val bottomBarDestination = navItems.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {

        NavigationBar(
            tonalElevation = 0.dp
        ) {

            navItems.forEach { bottomNavItem ->

                val selected = bottomNavItem.route == backStackEntry?.destination?.route

                NavigationBarItem(
                    selected = selected,
                    onClick = { onItemClick(bottomNavItem) },
                    icon = {
                        Icon(
                            painter = painterResource(id = bottomNavItem.icon),
                            contentDescription = "${bottomNavItem.navTitle} icon",
                            modifier = Modifier.size(25.dp)
                        )
                    },
                    label = {
                        Text(text = bottomNavItem.navTitle)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = primary_green,
                        selectedTextColor = primary_green,
                        unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                        unselectedTextColor = MaterialTheme.colorScheme.onBackground,
                        indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(LocalAbsoluteTonalElevation.current)
                    )
                )
            }
        }
    }
}


data class BottomNavItem(
    @DrawableRes val icon: Int,
    val navTitle: String,
    val route: String
)

val navItems = listOf(

    BottomNavItem(
        icon = R.drawable.shop,
        navTitle = "Shop",
        route = Screens.ShopScreen.route
    ),
    BottomNavItem(
        icon = R.drawable.explore,
        navTitle = "Explore",
        route = Screens.ExploreScreen.route
    ),
    BottomNavItem(
        icon = R.drawable.cart,
        navTitle = "Cart",
        route = Screens.CartScreen.route
    ),
    BottomNavItem(
        icon = R.drawable.favorite,
        navTitle = "Favorite",
        route = Screens.FavoriteScreen.route
    ),
    BottomNavItem(
        icon = R.drawable.account,
        navTitle = "Account",
        route = Screens.AccountScreen.route
    )
)