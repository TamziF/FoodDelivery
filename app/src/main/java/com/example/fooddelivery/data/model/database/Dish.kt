package com.example.fooddelivery.data.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "Dishes")
data class Dish(
    @ColumnInfo val imageSrc: String,
    @ColumnInfo val name: String,
    @ColumnInfo val strCategory: String,
    @ColumnInfo val ingredients: String,
    @PrimaryKey val idMeal: String
)
