package com.example.fooddelivery.ui.model

import java.util.UUID

data class Dish(
    val imageSrc: String,
    val name: String,
    val ingredients: String,
    val id: String = UUID.randomUUID().toString()
)
