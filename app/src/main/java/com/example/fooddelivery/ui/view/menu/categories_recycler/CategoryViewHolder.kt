package com.example.fooddelivery.ui.view.menu.categories_recycler

import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.databinding.CategoryCardBinding
import com.example.fooddelivery.ui.model.Category

class CategoryViewHolder(
    private val binding: CategoryCardBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(category: Category){
        binding.categoryText.text = category.category
    }

}