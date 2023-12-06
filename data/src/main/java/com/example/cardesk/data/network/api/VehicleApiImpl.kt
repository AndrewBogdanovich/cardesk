package com.example.cardesk.data.network.api

import com.example.cardesk.data.network.model.MakeResponse

class VehicleApiImpl(private val vehicleApiService: VehicleApiService) : VehicleApiService {
    override suspend fun getAllVehicle() = vehicleApiService.getAllVehicle()

    override suspend fun getVehiclesByModel(model: String) =
        vehicleApiService.getVehiclesByModel(model)

    override suspend fun getVehiclesByMark(mark: String) = vehicleApiService.getVehiclesByMark(mark)
    override suspend fun getMakes(): List<MakeResponse> = vehicleApiService.getMakes()
}