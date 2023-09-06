package com.example.cardesk.network.api

import com.example.cardesk.network.model.VehicleRequest
import com.example.cardesk.network.model.VehicleResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface VehicleApiService {

    @GET("api/data/vehicle")
    suspend fun getAllVehicle(): List<VehicleResponse>

    @GET("api/data/vehicle")
    suspend fun getVehiclesByModel(@Query("where") model: String): List<VehicleResponse>

    @GET("api/data/vehicle")
    suspend fun getVehiclesByMark(@Query("where") mark: String): List<VehicleResponse>

    @POST("api/data/vehicle")
    suspend fun addVehicle(@Body vehicleRequest: VehicleRequest)
}