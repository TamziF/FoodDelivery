package com.example.fooddelivery.ui.view.menu.categories_recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.fooddelivery.ui.model.Category

class CategoryCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.category == newItem.category
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.category == newItem.category && oldItem.isChosen == newItem.isChosen
    }

}