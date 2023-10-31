package com.example.cardesk.data.network.api

import com.example.cardesk.data.network.model.VehicleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VehicleApiService {

    @GET("api/data/vehicle")
    suspend fun getAllVehicle(): List<VehicleResponse>

    @GET("api/data/vehicle")
    suspend fun getVehiclesByModel(@Query("where") model: String): List<VehicleResponse>

    @GET("api/data/vehicle")
    suspend fun getVehiclesByMark(@Query("where") mark: String): List<VehicleResponse>
}