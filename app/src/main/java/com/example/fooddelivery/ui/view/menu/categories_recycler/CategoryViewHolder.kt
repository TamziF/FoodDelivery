package com.example.fooddelivery.ui.view.menu.categories_recycler

import android.graphics.Color
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddelivery.databinding.CategoryCardBinding
import com.example.fooddelivery.data.model.database.Category

class CategoryViewHolder(
    private val binding: CategoryCardBinding
) : RecyclerView.ViewHolder(binding.root) {

    lateinit var onClickAction: () -> Unit

    var viewHolderPosition = -1

    var chosenColor: Int = 0
    var notChosenColor: Int = 0

    fun bind(category: Category) {
        binding.categoryText.text = category.category

        if (category.isChosen)
            binding.frame.setBackgroundColor(chosenColor)
        else
            binding.frame.setBackgroundColor(notChosenColor)

        binding.card.setOnClickListener {
            onClickAction()
            Log.v("POSITIONSOLEOLE", "position.toString()")
        }
    }

}