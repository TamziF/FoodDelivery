package com.example.fooddelivery.ioc

import com.example.fooddelivery.data.datasource.network.Network
import com.example.fooddelivery.data.repositories.NetworkRepository
import com.example.fooddelivery.data.repositories.NetworkRepositoryImpl

class ApplicationComponent {

    private val network: Network = Network()

    private val networkRepository: NetworkRepository = NetworkRepositoryImpl(network.api)

    val viewModelFactory: ViewModelFactory = ViewModelFactory(networkRepository)

}