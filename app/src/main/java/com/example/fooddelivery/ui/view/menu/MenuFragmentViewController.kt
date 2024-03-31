package com.example.fooddelivery.ui.view.menu

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fooddelivery.databinding.FragmentMenuBinding
import com.example.fooddelivery.ui.stateholders.MenuViewModel
import com.example.fooddelivery.ui.view.menu.categories_recycler.CategoriesAdapter
import com.example.fooddelivery.ui.view.menu.dishes_recycler.DishesAdapter
import kotlinx.coroutines.launch

class MenuFragmentViewController(
    private var fragment: MenuFragment?,
    private val viewModel: MenuViewModel,
    binding: FragmentMenuBinding
) {

    private val dishesRecycler = binding.dishesRecycler
    private val categoriesRecycler = binding.categoriesRecycler

    private val dishesAdapter = DishesAdapter()
    private val categoriesAdapter = CategoriesAdapter()

    fun bindViews() {
        bindDishesRecycler()
        bindCategoriesRecycler()
    }

    private fun bindCategoriesRecycler() {
        categoriesRecycler.layoutManager = LinearLayoutManager(fragment!!.requireContext(), LinearLayoutManager.HORIZONTAL, false)
        categoriesRecycler.adapter = categoriesAdapter

        fragment!!.viewLifecycleOwner.lifecycleScope.launch {
            fragment!!.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.categories.collect { categoriesList ->
                    categoriesAdapter.submitList(categoriesList)
                }
            }
        }
    }

    private fun bindDishesRecycler() {
        dishesRecycler.layoutManager = LinearLayoutManager(fragment!!.requireContext())
        dishesRecycler.adapter = dishesAdapter

        fragment!!.viewLifecycleOwner.lifecycleScope.launch {
            fragment!!.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.dishes.collect { dishesList ->
                    dishesAdapter.submitList(dishesList)
                }
            }
        }
    }

    fun cleanReferences() {
        fragment = null
    }

}