package com.example.cardesk.domain.usecase

import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.helper.AdvertisementApiHelperImpl
import com.example.cardesk.data.network.model.AdvertisementResponse

class GetAdsByIdUseCase {

    suspend fun invoke(id: String): List<AdvertisementResponse> {
        val adsApiHelper = AdvertisementApiHelperImpl(RetrofitClient.advertisementApiService)
        return adsApiHelper.getAdsById("objectId='${id}'")
    }
}