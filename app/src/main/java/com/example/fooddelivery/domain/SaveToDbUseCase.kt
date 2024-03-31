package com.example.fooddelivery.domain

import com.example.fooddelivery.data.model.database.Category
import com.example.fooddelivery.data.model.database.Dish
import com.example.fooddelivery.data.model.network.categories.CategoryResponse
import com.example.fooddelivery.data.model.network.dishes.DishResponse
import com.example.fooddelivery.data.repositories.DatabaseRepository
import com.example.fooddelivery.data.repositories.NetworkRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

enum class UseCaseState { SAVING, SAVED, FAILED }

class SaveToDbUseCase(
    private val networkRepository: NetworkRepository,
    private val databaseRepository: DatabaseRepository
) {

    private val _categoriesState: MutableStateFlow<UseCaseState> =
        MutableStateFlow(UseCaseState.SAVING)
    val categoriesState: StateFlow<UseCaseState> = _categoriesState

    private val _dishesState: MutableStateFlow<UseCaseState> = MutableStateFlow(UseCaseState.SAVING)
    val dishesState: StateFlow<UseCaseState> = _dishesState

    private val useCaseScope = CoroutineScope(Job() + Dispatchers.IO)

    fun loadCategories() {
        _categoriesState.value = UseCaseState.SAVING
        useCaseScope.launch {
            try {
                val requestAnswer = networkRepository.downloadCategories()
                if (requestAnswer.isSuccessful) {
                    databaseRepository.insertCategories(convertCategoriesRequest(requestAnswer.body()?.categories))
                    _categoriesState.value = UseCaseState.SAVED
                } else {
                    _categoriesState.value = UseCaseState.FAILED
                }
            } catch (e: Exception) {
                _categoriesState.value = UseCaseState.FAILED
            }
        }
    }

    fun loadDishes() {
        _dishesState.value = UseCaseState.SAVING
        useCaseScope.launch(Dispatchers.IO) {
            try {
                val requestAnswer = networkRepository.downloadAllDishes()
                if (requestAnswer.isSuccessful) {
                    databaseRepository.insertDishes(convertDishRequest(requestAnswer.body()?.meals))
                    _dishesState.value = UseCaseState.SAVED
                } else {
                    _dishesState.value = UseCaseState.FAILED
                }
            } catch (e: Exception) {
                _dishesState.value = UseCaseState.FAILED
            }
        }
    }

    fun clear() {
        useCaseScope.cancel()
    }

    private fun convertCategoriesRequest(categories: List<CategoryResponse>?): List<Category> {
        val categoriesList: ArrayList<Category> = ArrayList()

        if (categories != null) {
            for (category in categories) {
                categoriesList.add(
                    Category(
                        category = category.strCategory,
                        isChosen = false,
                        id = category.idCategory
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
                        ingredients = buildIngredientsString(dishResponse),
                        strCategory = dishResponse.strCategory,
                        idMeal = dishResponse.idMeal
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