package com.example.cardesk.data.repository

import com.example.cardesk.data.network.api.AdvertisementApiHelper
import com.example.cardesk.data.network.model.toModel
import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.domain.repository.AdvertisementRepository

class AdvertisementRepositoryImpl(private val advertisementApiHelper: AdvertisementApiHelper) :
    AdvertisementRepository {
    override suspend fun getAllAds(): List<AdvertisementModel> {
        val network = advertisementApiHelper.getAllAds()
        return network.map { it.toModel() }
    }

    override suspend fun getAdsById(id: String): List<AdvertisementModel> {
        TODO("Not yet implemented")
    }

    override suspend fun addAds(ads: AdvertisementModel) {
        TODO("Not yet implemented")
    }
}