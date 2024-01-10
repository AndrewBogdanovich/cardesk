package com.example.cardesk.presentation.advertisement.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.api.make.MakeApiHelper
import com.example.cardesk.data.network.api.make.MakeApiHelperImpl
import com.example.cardesk.data.repository.GetMakesRepositoryImpl
import com.example.cardesk.domain.usecase.GetMakesUseCase

class CreateAdvertisementViewModelFactory: ViewModelProvider.Factory {

    private val fetchGetMakesRepository by lazy {
        GetMakesRepositoryImpl(MakeApiHelperImpl(RetrofitClient.makeApiService))
    }

    private val fetchGetMakesUseCase by lazy {
        GetMakesUseCase(fetchGetMakesRepository)
    }
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CreateAdvertisementViewModel(fetchGetMakesUseCase) as T
    }
}