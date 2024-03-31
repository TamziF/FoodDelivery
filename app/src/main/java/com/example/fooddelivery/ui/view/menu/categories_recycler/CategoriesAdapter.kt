package com.example.fooddelivery.ui.view.menu.categories_recycler

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.fooddelivery.databinding.CategoryCardBinding
import com.example.fooddelivery.data.model.database.Category

class CategoriesAdapter(
    private val chosenColor: Int,
    private val notChosenColor: Int,
    private val onItemClicked: (String) -> Unit
) : ListAdapter<Category, CategoryViewHolder>(
    CategoryCallback()
) {

    private var chosenCategoryPosition: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            CategoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = getItem(position)
        item.isChosen = position == chosenCategoryPosition

        holder.chosenColor = chosenColor
        holder.notChosenColor = notChosenColor

        holder.viewHolderPosition = position
        holder.onClickAction = {
            onItemClicked(item.category)

            val pastPosition = chosenCategoryPosition
            chosenCategoryPosition = holder.viewHolderPosition

            notifyItemChanged(pastPosition)
            notifyItemChanged(chosenCategoryPosition)
        }

        holder.bind(item)
    }
}