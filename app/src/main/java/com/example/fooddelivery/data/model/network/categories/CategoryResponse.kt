package com.example.fooddelivery.data.model.network.categories

import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    val idCategory: String,
    val strCategory: String
)