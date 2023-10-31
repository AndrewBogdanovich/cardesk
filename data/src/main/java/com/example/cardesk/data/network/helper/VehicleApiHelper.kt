package com.example.cardesk.data.network.helper

import com.example.cardesk.data.network.model.VehicleResponse

interface VehicleApiHelper {
    suspend fun getAllVehicle(): List<VehicleResponse>
    suspend fun getVehiclesByModel(model: String): List<VehicleResponse>
    suspend fun getVehiclesByMark(mark: String): List<VehicleResponse>
}