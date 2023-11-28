package com.example.cardesk.domain.repository

import com.example.cardesk.domain.model.AdvertisementModel

interface AdvertisementRepository {
    suspend fun getAllAds(): List<AdvertisementModel>
    suspend fun getAdsById(id: String): List<AdvertisementModel>
    suspend fun addAds(ads: AdvertisementModel)
}