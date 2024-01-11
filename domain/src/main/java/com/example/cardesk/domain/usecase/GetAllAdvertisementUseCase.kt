package com.example.cardesk.domain.usecase

import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.domain.repository.AdvertisementRepository

class GetAllAdvertisementUseCase(private val advertisementRepository: AdvertisementRepository) {
    suspend fun execute(): List<AdvertisementModel> {
        return advertisementRepository.getAllAds()
    }
}