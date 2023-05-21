package com.loki.nectar.presentation.favorite

import com.loki.nectar.R

val favorites = listOf(
    Favorite(
        image = R.drawable.sprite,
        name = "Sprite Can",
        amount = "325ml",
        price = "1.50"
    ),
    Favorite(
        image = R.drawable.dietcoke,
        name = "Diet Coke",
        amount = "325ml",
        price = "1.99"
    ),
    Favorite(
        image = R.drawable.applejuice,
        name = "Apple & Grape Juice",
        amount = "2L",
        price = "15.50"
    ),
    Favorite(
        image = R.drawable.cocacola,
        name = "Coca Cola Can",
        amount = "325ml",
        price = "4.99"
    ),
    Favorite(
        image = R.drawable.pepsi,
        name = "Pepsi Can",
        amount = "325ml",
        price = "4.99"
    )
)

data class Favorite(
    val image: Int,
    val name: String,
    val amount: String,
    val price: String
)