package com.example.cardesk.advertisement

import androidx.lifecycle.ViewModel
import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.helper.AdvertisementApiHelperImpl
import com.example.cardesk.data.network.model.AdvertisementRequest

class CreateAdvertisementViewModel : ViewModel() {

    suspend fun createAds(newAds: AdvertisementRequest) {
        val adsApiHelper =
            AdvertisementApiHelperImpl(RetrofitClient.advertisementApiService)
        adsApiHelper.addAds(newAds)
    }
}