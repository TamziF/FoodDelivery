package com.example.fooddelivery.ui.stateholders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.data.model.database.Category
import com.example.fooddelivery.data.model.database.Dish
import com.example.fooddelivery.data.repositories.DatabaseRepository
import com.example.fooddelivery.domain.SaveToDbUseCase
import com.example.fooddelivery.domain.UseCaseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MenuViewModel(
    private val databaseRepository: DatabaseRepository,
    private val useCase: SaveToDbUseCase
) : ViewModel() {

    private val _categories: MutableStateFlow<List<Category>> = MutableStateFlow(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    private val _dishes: MutableStateFlow<List<Dish>> = MutableStateFlow(emptyList())
    val dishes: StateFlow<List<Dish>> = _dishes


    init {
        useCase.loadCategories()
        useCase.loadDishes()
        subscribeCategoriesState()
    }

    private fun subscribeCategoriesState() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.categoriesState.collect { state ->
                if (state == UseCaseState.SAVED || state == UseCaseState.FAILED) {
                    getCategories()
                }
            }
        }
    }

    private fun subscribeDishesState() {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.dishesState.collect { state ->
                if (state == UseCaseState.SAVED || state == UseCaseState.FAILED) {

                }
            }
        }
    }

    private fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            val categories = databaseRepository.getAllCategories()
            if (categories.isNotEmpty()) {
                _categories.value = categories

                // setting first category chosen
                val category = _categories.value[0]
                getDishes(category.category)
            }
        }
    }

    private var job: Job? = null

    fun getDishes(category: String) {
        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            while (useCase.dishesState.value == UseCaseState.SAVING)
                delay(100L)
            _dishes.value = databaseRepository.getDishesByCategory(category)
        }
    }

    override fun onCleared() {
        useCase.clear()
        super.onCleared()
    }
}