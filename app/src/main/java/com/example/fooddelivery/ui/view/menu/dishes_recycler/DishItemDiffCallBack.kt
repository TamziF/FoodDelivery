package com.example.fooddelivery.ui.view.menu.dishes_recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.fooddelivery.data.model.database.Dish

class DishItemDiffCallBack : DiffUtil.ItemCallback<Dish>() {
    override fun areItemsTheSame(oldItem: Dish, newItem: Dish): Boolean {
        return oldItem.idMeal == newItem.idMeal
    }

    override fun areContentsTheSame(oldItem: Dish, newItem: Dish): Boolean {
        return oldItem == newItem
    }
}