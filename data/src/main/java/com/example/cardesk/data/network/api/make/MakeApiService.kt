package com.example.cardesk.data.network.api.make

import com.example.cardesk.data.network.model.MakeResponse
import retrofit2.http.GET

interface MakeApiService {
    @GET("api/data/make")
    suspend fun getAllMakes(): List<MakeResponse>
}