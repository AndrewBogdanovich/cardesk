package com.example.cardesk.network.helper

import com.example.cardesk.network.api.VehicleApiService
import com.example.cardesk.network.model.VehicleRequest

class VehicleApiImpl(private val vehicleApiService: VehicleApiService) : VehicleApiHelper {
    override suspend fun getAllVehicle() = vehicleApiService.getAllVehicle()

    override suspend fun getVehiclesByModel(model: String) =
        vehicleApiService.getVehiclesByModel(model)

    override suspend fun getVehiclesByMark(mark: String) = vehicleApiService.getVehiclesByMark(mark)

    override suspend fun addVehicle(vehicleRequest: VehicleRequest) =
        vehicleApiService.addVehicle(vehicleRequest)
}