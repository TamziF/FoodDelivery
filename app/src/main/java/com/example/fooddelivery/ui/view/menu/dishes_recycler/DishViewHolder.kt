package com.example.fooddelivery.ui.view.menu.dishes_recycler

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fooddelivery.ui.model.Dish
import com.example.fooddelivery.R
import com.example.fooddelivery.databinding.DishCardBinding

class DishViewHolder(
    private val binding: DishCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dish: Dish) {
        binding.dishImage.load(dish.imageSrc) {
            error(R.drawable.broken_image)
        }

        binding.dishName.text = dish.name
        binding.dishIngredients.text = dish.ingredients
    }

}