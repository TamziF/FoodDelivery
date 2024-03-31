package com.example.fooddelivery.ioc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fooddelivery.data.repositories.DatabaseRepository
import com.example.fooddelivery.data.repositories.NetworkRepository
import com.example.fooddelivery.domain.SaveToDbUseCase
import com.example.fooddelivery.ui.stateholders.MenuViewModel

class ViewModelFactory(
    private val databaseRepository: DatabaseRepository,
    private val saveToDbUseCase: () -> SaveToDbUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>) = when (modelClass) {
        MenuViewModel::class.java -> MenuViewModel(databaseRepository, saveToDbUseCase())

        else -> throw IllegalArgumentException()
    } as T
}