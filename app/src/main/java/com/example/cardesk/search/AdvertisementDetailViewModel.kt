package com.example.cardesk.search

import androidx.lifecycle.ViewModel
import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.helper.AdvertisementApiHelperImpl
import com.example.cardesk.data.network.model.AdvertisementResponse

class AdvertisementDetailViewModel: ViewModel() {
    suspend fun getAds(id: String): List<AdvertisementResponse>{
        val adsApiHelper = AdvertisementApiHelperImpl(RetrofitClient.advertisementApiService)
        return adsApiHelper.getAdsById("objectId='${id}'")
    }
}