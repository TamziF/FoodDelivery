package com.example.fooddelivery.data.repositories

import com.example.fooddelivery.data.datasource.database.CategoryDao
import com.example.fooddelivery.data.datasource.database.DishDao
import com.example.fooddelivery.data.model.database.Category
import com.example.fooddelivery.data.model.database.Dish

interface DatabaseRepository {

    fun getAllDishes(): List<Dish>

    fun getDishesByCategory(category: String): List<Dish>

    fun insertDishes(dishes: List<Dish>)

    fun getAllCategories(): List<Category>

    fun insertCategories(categories: List<Category>)

}

class DatabaseRepositoryImpl(
    private val dishDao: DishDao,
    private val categoryDao: CategoryDao
) : DatabaseRepository {
    override fun getAllDishes(): List<Dish> {
        return dishDao.getAllDishes()
    }

    override fun getDishesByCategory(category: String): List<Dish> {
        return dishDao.getDishesByCategory(category)
    }

    override fun insertDishes(dishes: List<Dish>) {
        dishDao.insertDishes(dishes)
    }

    override fun getAllCategories(): List<Category> {
        return categoryDao.getAllCategories()
    }

    override fun insertCategories(categories: List<Category>) {
        categoryDao.insertCategories(categories)
    }
}