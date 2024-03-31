package com.example.fooddelivery.data.model.network.dishes

import kotlinx.serialization.Serializable

@Serializable
data class AllDishesResponse(
    val meals: List<DishResponse>
)