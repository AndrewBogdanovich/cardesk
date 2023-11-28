package com.example.cardesk.data.repository

import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.helper.AdvertisementApiHelperImpl
import com.example.cardesk.data.transformer.AdvertisementTransformer
import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.domain.repository.AdvertisementRepository

class AdvertisementRepositoryImpl : AdvertisementRepository {
    override suspend fun getAllAds(): List<AdvertisementModel> {
        val apiHelper =
            AdvertisementApiHelperImpl(RetrofitClient.advertisementApiService)
        val network = apiHelper.getAllAds()
        val result = network.map { adItem ->
                AdvertisementTransformer.transformToModel(adItem)
        }
        return result
    }

    override suspend fun getAdsById(id: String): List<AdvertisementModel> {
        TODO("Not yet implemented")
    }

    override suspend fun addAds(ads: AdvertisementModel) {
        TODO("Not yet implemented")
    }
}