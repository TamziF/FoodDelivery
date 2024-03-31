package com.example.fooddelivery.ioc

import android.content.Context
import com.example.fooddelivery.data.datasource.database.FoodDatabase
import com.example.fooddelivery.data.datasource.network.Network
import com.example.fooddelivery.data.repositories.DatabaseRepository
import com.example.fooddelivery.data.repositories.DatabaseRepositoryImpl
import com.example.fooddelivery.data.repositories.NetworkRepository
import com.example.fooddelivery.data.repositories.NetworkRepositoryImpl
import com.example.fooddelivery.domain.SaveToDbUseCase

class ApplicationComponent(
    private val context: Context
) {

    private val network: Network = Network()
    private val database: FoodDatabase = FoodDatabase.getInstance(context)

    private val networkRepository: NetworkRepository = NetworkRepositoryImpl(network.api)
    private val databaseRepository: DatabaseRepository = DatabaseRepositoryImpl(database.dishDao(), database.categoryDao())

    private val saveToDbUseCaseFactory = { // creates new UseCase instance each time
        SaveToDbUseCase(networkRepository, databaseRepository)
    }

    val viewModelFactory: ViewModelFactory = ViewModelFactory(databaseRepository, saveToDbUseCaseFactory)

}