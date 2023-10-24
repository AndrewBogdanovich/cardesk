package com.example.cardesk.domain.usecase

import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.helper.VehicleApiImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GetAllVehicleUseCase {
    fun invoke(){
        val vehicleApiHelper = VehicleApiImpl(RetrofitClient.vehicleApiService)
        GlobalScope.launch {
            val all = vehicleApiHelper.getAllVehicle()
            val byModel = vehicleApiHelper.getVehiclesByModel("model='Mustang'")
            val byMark = vehicleApiHelper.getVehiclesByMark("mark='Ford'")
            val q = byMark
        }
    }
}