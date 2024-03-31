package com.example.fooddelivery.data.repositories

import com.example.fooddelivery.data.datasource.network.ApiService
import com.example.fooddelivery.data.model.network.categories.AllCategoriesResponse
import com.example.fooddelivery.data.model.network.dishes.AllDishesResponse
import retrofit2.Response

interface NetworkRepository {

    suspend fun downloadAllDishes(): Response<AllDishesResponse>

    suspend fun downloadCategories(): Response<AllCategoriesResponse>

}

class NetworkRepositoryImpl(
    private val api: ApiService
) : NetworkRepository {
    override suspend fun downloadAllDishes(): Response<AllDishesResponse> {
        return api.downloadAllDishes()
    }

    override suspend fun downloadCategories(): Response<AllCategoriesResponse> {
        return api.downloadCategories()
    }

}