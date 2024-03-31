package com.example.fooddelivery.data.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Categories")
data class Category(
    @PrimaryKey val id: String,
    @ColumnInfo val category: String,
    @ColumnInfo var isChosen: Boolean
)