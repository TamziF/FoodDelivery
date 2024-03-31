package com.example.fooddelivery.data.datasource.network

import com.example.fooddelivery.data.model.network.categories.AllCategoriesResponse
import com.example.fooddelivery.data.model.network.dishes.AllDishesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("search.php?s")
    suspend fun downloadAllDishes(): Response<AllDishesResponse>

    @GET("categories.php")
    suspend fun downloadCategories(): Response<AllCategoriesResponse>

}