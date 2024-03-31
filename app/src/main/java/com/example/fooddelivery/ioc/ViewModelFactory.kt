package com.example.fooddelivery.ioc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fooddelivery.data.repositories.NetworkRepository
import com.example.fooddelivery.ui.stateholders.MenuViewModel

class ViewModelFactory(
    private val networkRepository: NetworkRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>) = when (modelClass) {
        MenuViewModel::class.java -> MenuViewModel(networkRepository)

        else -> throw IllegalArgumentException()
    } as T
}