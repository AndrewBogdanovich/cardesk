package com.example.cardesk.domain.usecase

import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.domain.repository.AdvertisementRepository

class GetAdsByIdUseCase(private val advertisementRepository: AdvertisementRepository) {
    suspend fun execute(id: String): List<AdvertisementModel> {
        return advertisementRepository.getAdsById(id)
    }
}