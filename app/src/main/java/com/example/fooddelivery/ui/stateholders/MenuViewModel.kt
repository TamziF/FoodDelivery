package com.example.fooddelivery.ui.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.data.model.network.categories.CategoryResponse
import com.example.fooddelivery.data.model.network.dishes.DishResponse
import com.example.fooddelivery.data.repositories.NetworkRepository
import com.example.fooddelivery.ui.model.Category
import com.example.fooddelivery.ui.model.Dish
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MenuViewModel(
    private val networkRepository: NetworkRepository
) : ViewModel() {

    private val _categories: MutableStateFlow<List<Category>> = MutableStateFlow(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    private val _dishes: MutableStateFlow<List<Dish>> = MutableStateFlow(emptyList())
    val dishes: StateFlow<List<Dish>> = _dishes

    init {
        getDishes()
        getCategories()
    }

    private fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            val requestAnswer = networkRepository.downloadCategories()
            if (requestAnswer.isSuccessful) {
                _categories.value = convertCategoriesRequest(requestAnswer.body()?.categories)
            }
        }
    }

    private fun getDishes() {
        viewModelScope.launch(Dispatchers.IO) {
            val requestAnswer = networkRepository.downloadAllDishes()
            if (requestAnswer.isSuccessful) {
                _dishes.value = convertDishRequest(requestAnswer.body()?.meals)
            }
        }
    }

    private fun convertCategoriesRequest(categories: List<CategoryResponse>?): List<Category> {
        val categoriesList: ArrayList<Category> = ArrayList()

        if (categories != null) {
            for (category in categories) {
                categoriesList.add(
                    Category(
                        category = category.strCategory,
                        isChosen = false
                    )
                )
            }
        }
        return categoriesList
    }

    private fun convertDishRequest(list: List<DishResponse>?): List<Dish> {
        val dishesList: ArrayList<Dish> = ArrayList()
        if (list != null) {
            for (dishResponse in list) {
                dishesList.add(
                    Dish(
                        imageSrc = dishResponse.strMealThumb,
                        name = dishResponse.strMeal,
                        ingredients = buildIngredientsString(dishResponse)
                    )
                )
            }
        }
        return dishesList
    }

    private fun buildIngredientsString(dishResponse: DishResponse): String {
        val ingredientsList = listOf(
            dishResponse.strIngredient1,
            dishResponse.strIngredient2,
            dishResponse.strIngredient3,
            dishResponse.strIngredient4,
            dishResponse.strIngredient5,
            dishResponse.strIngredient6,
            dishResponse.strIngredient7,
            dishResponse.strIngredient8,
            dishResponse.strIngredient9,
            dishResponse.strIngredient10,
            dishResponse.strIngredient11,
            dishResponse.strIngredient12,
            dishResponse.strIngredient13,
            dishResponse.strIngredient14,
            dishResponse.strIngredient15,
            dishResponse.strIngredient16,
            dishResponse.strIngredient17,
            dishResponse.strIngredient18,
            dishResponse.strIngredient19,
            dishResponse.strIngredient20
        )

        val filteredIngredients = ingredientsList.filter { it?.isNotEmpty() ?: false }
        return filteredIngredients.joinToString(", ")
    }

}