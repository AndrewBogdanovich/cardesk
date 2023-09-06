package com.example.cardesk.network.helper

import com.example.cardesk.network.model.VehicleRequest
import com.example.cardesk.network.model.VehicleResponse

interface VehicleApiHelper {
    suspend fun getAllVehicle(): List<VehicleResponse>
    suspend fun getVehiclesByModel(model: String): List<VehicleResponse>
    suspend fun getVehiclesByMark(mark: String): List<VehicleResponse>
    suspend fun addVehicle(vehicleRequest: VehicleRequest)
}