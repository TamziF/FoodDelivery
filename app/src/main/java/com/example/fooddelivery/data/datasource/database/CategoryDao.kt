package com.example.fooddelivery.data.datasource.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fooddelivery.data.model.database.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM Categories")
    fun getAllCategories(): List<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(categories: List<Category>)
}