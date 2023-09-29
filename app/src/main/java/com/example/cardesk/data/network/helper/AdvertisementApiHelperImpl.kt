package com.example.cardesk.data.network.helper

import com.example.cardesk.data.network.api.AdvertisementApiService
import com.example.cardesk.data.network.model.AdvertisementResponse

class AdvertisementApiHelperImpl(private val advertisementApiService: AdvertisementApiService) :
    AdvertisementApiHelper {
    override suspend fun getAllAds(): List<AdvertisementResponse> =
        advertisementApiService.getAllAds()
}