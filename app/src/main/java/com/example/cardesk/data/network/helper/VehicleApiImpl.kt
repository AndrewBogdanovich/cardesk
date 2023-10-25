package com.example.cardesk.data.network.helper

import com.example.cardesk.data.network.api.VehicleApiService

class VehicleApiImpl(private val vehicleApiService: VehicleApiService) : VehicleApiHelper {
    override suspend fun getAllVehicle() = vehicleApiService.getAllVehicle()

    override suspend fun getVehiclesByModel(model: String) =
        vehicleApiService.getVehiclesByModel(model)

    override suspend fun getVehiclesByMark(mark: String) = vehicleApiService.getVehiclesByMark(mark)
}