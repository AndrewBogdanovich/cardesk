package com.example.cardesk.presentation.search

import androidx.lifecycle.ViewModel
import com.example.cardesk.data.repository.AdvertisementRepositoryImpl
import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.domain.usecase.GetAllAdvertisementUseCase

class SearchViewModel: ViewModel() {

    suspend fun loadAds(): List<AdvertisementModel> {
        val repo =
            AdvertisementRepositoryImpl()
        val uc = GetAllAdvertisementUseCase(repo)
        return uc.execute()
    }
}