package com.loki.nectar.presentation.explore

import androidx.compose.ui.graphics.Color
import com.loki.nectar.R


data class Product(
    val name: String,
    val image: Int,
    val color: Color
)

val products = listOf(
    Product(
        name = "Fresh Fruits \n& Vegetable",
        image = R.drawable.vegetables,
        color = Color(0xFF53B175)
    ),
    Product(
        name = "Cooking Oil \n& Ghee",
        image = R.drawable.oil,
        color = Color(0xFFF8A44C)
    ),
    Product(
        name = "Meat & Fish",
        image = R.drawable.meat,
        color = Color(0xFFF7A593)
    ),
    Product(
        name = "Bakery & Snacks",
        image = R.drawable.snacks,
        color = Color(0xFFD3B0E0)
    ),
    Product(
        name = "Dairy & Eggs",
        image = R.drawable.dairy,
        color = Color(0xFFFDE598)
    ),
    Product(
        name = "Beverages",
        image = R.drawable.beverages,
        color = Color(0xFFB7DFF5)
    )
)