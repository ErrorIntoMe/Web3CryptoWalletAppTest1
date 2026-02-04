package core

import data.ApiService
import data.NetworkScreenRepository
import data.RepositoryImpl
import domain.LoadScreenUseCase
import network.HttpClientFactory

class SharedFactory {

    fun createSharedApi(): ShareApi {
        val client = HttpClientFactory().create()
        val apiService = ApiService(client)

        val repository = NetworkScreenRepository(apiService)
        val useCase = LoadScreenUseCase(repository)
        return ShareApi(useCase)
    }
}