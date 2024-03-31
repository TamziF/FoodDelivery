package com.example.fooddelivery.data.datasource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fooddelivery.data.model.database.Category
import com.example.fooddelivery.data.model.database.Dish

@Database(version = 1, entities = [Dish::class, Category::class])
abstract class FoodDatabase : RoomDatabase() {
    abstract fun dishDao(): DishDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        private var INSTANCE: FoodDatabase? = null

        fun getInstance(context: Context): FoodDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}