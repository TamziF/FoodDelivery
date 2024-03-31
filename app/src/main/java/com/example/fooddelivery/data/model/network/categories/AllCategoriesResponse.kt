package com.example.fooddelivery.data.model.network.categories

import kotlinx.serialization.Serializable

@Serializable
data class AllCategoriesResponse(
    val categories: List<CategoryResponse>
)