package com.example.cardesk.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.api.advertisement.AdvertisementApiHelperImpl
import com.example.cardesk.data.repository.AdvertisementRepositoryImpl
import com.example.cardesk.domain.usecase.GetAllAdvertisementUseCase

class SearchViewModelFactory : ViewModelProvider.Factory {

    private val fetchAdsRepository by lazy {
        AdvertisementRepositoryImpl(
            AdvertisementApiHelperImpl(
                RetrofitClient.advertisementApiService
            )
        )
    }

    private val fetchGetAllADsUseCase by lazy {
        GetAllAdvertisementUseCase(
            fetchAdsRepository
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchViewModel(fetchGetAllADsUseCase) as T
    }
}