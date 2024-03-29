package com.example.cardesk.data.network.api.advertisement

import com.example.cardesk.data.network.model.AdvertisementRequest
import com.example.cardesk.data.network.model.AdvertisementResponse

interface AdvertisementApiHelper {
    suspend fun getAllAds(): List<AdvertisementResponse>

    suspend fun getAdsById(id: String): List<AdvertisementResponse>

    suspend fun addAds(ads: AdvertisementRequest)
}