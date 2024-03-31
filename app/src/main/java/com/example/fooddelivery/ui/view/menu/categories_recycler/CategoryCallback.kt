package com.example.fooddelivery.ui.view.menu.categories_recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.fooddelivery.data.model.database.Category

class CategoryCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }

}