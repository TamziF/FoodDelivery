package com.example.fooddelivery.ui.view.menu.dishes_recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.fooddelivery.data.model.database.Dish
import com.example.fooddelivery.databinding.DishCardBinding

class DishesAdapter : ListAdapter<Dish, DishViewHolder>(
    DishItemDiffCallBack()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val binding = DishCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DishViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}