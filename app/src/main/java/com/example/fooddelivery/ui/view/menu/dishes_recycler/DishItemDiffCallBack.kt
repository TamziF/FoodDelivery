package com.example.fooddelivery.ui.view.menu.dishes_recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.fooddelivery.ui.model.Dish

class DishItemDiffCallBack : DiffUtil.ItemCallback<Dish>() {
    override fun areItemsTheSame(oldItem: Dish, newItem: Dish): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Dish, newItem: Dish): Boolean {
        return oldItem == newItem
    }
}