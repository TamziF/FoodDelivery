package com.example.fooddelivery

import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.databinding.DishCardBinding

class DishViewHolder(
    private val binding: DishCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dish: Dish) {
        binding.dishImage.setImageResource(R.drawable.pizza)

        binding.dishName.text = dish.name
        binding.dishIngredients.text = dish.ingredients
    }

}