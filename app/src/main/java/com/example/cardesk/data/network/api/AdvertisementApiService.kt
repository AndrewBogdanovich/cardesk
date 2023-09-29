package com.example.cardesk.data.network.api

import com.example.cardesk.data.network.model.AdvertisementResponse
import retrofit2.http.GET

interface AdvertisementApiService {

    @GET("api/data/advertisements")
    suspend fun getAllAds(): List<AdvertisementResponse>
}