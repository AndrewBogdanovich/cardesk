package com.example.cardesk.data.network.api

import com.example.cardesk.data.network.model.AdvertisementRequest
import com.example.cardesk.data.network.model.AdvertisementResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AdvertisementApiService {
    @GET("api/data/advertisements")
    suspend fun getAllAds(): List<AdvertisementResponse>

    @GET("api/data/advertisements")
    suspend fun getAdsById(@Query("where") id: String): List<AdvertisementResponse>

    @POST("api/data/advertisements")
    suspend fun addAds(ads: AdvertisementRequest)
}