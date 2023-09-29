package com.example.cardesk.data.network.helper

import com.example.cardesk.data.network.model.AdvertisementResponse

interface AdvertisementApiHelper {
    suspend fun getAllAds(): List<AdvertisementResponse>
}