package com.example.cardesk.presentation.search

import androidx.lifecycle.ViewModel
import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.api.AdvertisementApiHelperImpl
import com.example.cardesk.data.network.model.AdvertisementResponse

class AdvertisementDetailViewModel: ViewModel() {
    suspend fun getAd(id: String): List<AdvertisementResponse> {
        val adsApiHelper = AdvertisementApiHelperImpl(RetrofitClient.advertisementApiService)
        return adsApiHelper.getAdsById("objectId='${id}'")
    }
}