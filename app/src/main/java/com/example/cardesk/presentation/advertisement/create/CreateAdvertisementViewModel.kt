package com.example.cardesk.presentation.advertisement.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.api.AdvertisementApiHelperImpl
import com.example.cardesk.data.network.api.VehicleApiImpl
import com.example.cardesk.data.network.model.AdvertisementRequest
import com.example.cardesk.data.network.model.MakeResponse

class CreateAdvertisementViewModel : ViewModel() {

    private val _makes = MutableLiveData<List<MakeResponse>>()
    val makes: LiveData<List<MakeResponse>> = _makes
    suspend fun createAds(newAds: AdvertisementRequest) {
        val adsApiHelper =
            AdvertisementApiHelperImpl(RetrofitClient.advertisementApiService)
        adsApiHelper.addAds(newAds)
    }

    suspend fun loadMakes() {
        val vehicleApiHelper = VehicleApiImpl(RetrofitClient.vehicleApiService)
        _makes.value = vehicleApiHelper.getMakes()
    }
}