package com.example.cardesk.presentation.search

import androidx.lifecycle.ViewModel
import com.example.cardesk.data.network.model.AdvertisementResponse
import com.example.cardesk.domain.usecase.GetAdsByIdUseCase

class AdvertisementDetailViewModel: ViewModel() {
    suspend fun getAds(id: String): List<AdvertisementResponse>{
        return GetAdsByIdUseCase().invoke(id)
    }
}