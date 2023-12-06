package com.example.cardesk.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.api.AdvertisementApiHelperImpl
import com.example.cardesk.data.repository.AdvertisementRepositoryImpl

class SearchViewModelFactory : ViewModelProvider.Factory {

    private val fetchAdsRepository by lazy {
        AdvertisementRepositoryImpl(
            AdvertisementApiHelperImpl(
                RetrofitClient.advertisementApiService
            )
        )
    }

    private val fetchGetAllADsUseCase by lazy {
        com.example.cardesk.domain.usecase.GetAllAdvertisementUseCase(
            fetchAdsRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchViewModel(fetchGetAllADsUseCase) as T
    }
}