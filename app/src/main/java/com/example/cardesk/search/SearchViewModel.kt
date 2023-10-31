package com.example.cardesk.search

import androidx.lifecycle.ViewModel
import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.helper.AdvertisementApiHelperImpl
import com.example.cardesk.data.network.model.AdvertisementResponse

class SearchViewModel: ViewModel() {

    suspend fun loadAds(): List<AdvertisementResponse> {
        val apiHelper =
            AdvertisementApiHelperImpl(RetrofitClient.advertisementApiService)
        return apiHelper.getAllAds()
    }
}