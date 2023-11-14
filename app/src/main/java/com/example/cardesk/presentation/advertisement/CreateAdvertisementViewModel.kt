package com.example.cardesk.presentation.advertisement

import androidx.lifecycle.ViewModel
import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.helper.AdvertisementApiHelperImpl
import com.example.cardesk.data.network.helper.VehicleApiHelperImpl
import com.example.cardesk.data.network.model.AdvertisementRequest
import com.example.cardesk.data.network.model.MakeResponse

class CreateAdvertisementViewModel : ViewModel() {

    suspend fun createAds(newAds: AdvertisementRequest) {
        val adsApiHelper =
            AdvertisementApiHelperImpl(RetrofitClient.advertisementApiService)
        adsApiHelper.addAds(newAds)
    }

    suspend fun loadMakes(): List<MakeResponse> {
        val vehicleApiHelper = VehicleApiHelperImpl(RetrofitClient.vehicleApiService)
        return vehicleApiHelper.getMakes()
    }
}