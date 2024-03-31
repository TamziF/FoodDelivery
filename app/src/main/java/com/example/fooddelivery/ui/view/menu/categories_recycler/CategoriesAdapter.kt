package com.example.fooddelivery.ui.view.menu.categories_recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.fooddelivery.databinding.CategoryCardBinding
import com.example.fooddelivery.ui.model.Category

class CategoriesAdapter : ListAdapter<Category, CategoryViewHolder>(
    CategoryCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            CategoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}