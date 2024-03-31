package com.example.fooddelivery.data.datasource.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fooddelivery.data.model.database.Dish

@Dao
interface DishDao {

    @Query("SELECT * FROM Dishes")
    fun getAllDishes(): List<Dish>

    @Query("SELECT * FROM Dishes WHERE strCategory = :category")
    fun getDishesByCategory(category: String): List<Dish>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDishes(dishes: List<Dish>)

}