package com.example.cardesk.di

import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.api.advertisement.AdvertisementApiHelper
import com.example.cardesk.data.network.api.advertisement.AdvertisementApiHelperImpl
import com.example.cardesk.data.network.api.advertisement.AdvertisementApiService
import com.example.cardesk.data.network.api.make.MakeApiHelper
import com.example.cardesk.data.network.api.make.MakeApiHelperImpl
import com.example.cardesk.data.network.api.make.MakeApiService
import com.example.cardesk.data.repository.AdvertisementRepositoryImpl
import com.example.cardesk.data.repository.GetMakesRepositoryImpl
import com.example.cardesk.domain.repository.AdvertisementRepository
import com.example.cardesk.domain.repository.GetMakesRepository
import org.koin.dsl.module


val dataModule = module {

    factory<MakeApiService> { RetrofitClient.getMakeApiService() }
    factory<AdvertisementApiService> { RetrofitClient.getAdvertisementApiService() }

    factory<MakeApiHelper> { MakeApiHelperImpl(makeApiService = get()) }
    factory<GetMakesRepository> { GetMakesRepositoryImpl(makeApiHelper = get()) }

    factory<AdvertisementApiHelper> { AdvertisementApiHelperImpl(advertisementApiService = get()) }
    factory<AdvertisementRepository> { AdvertisementRepositoryImpl(advertisementApiHelper = get()) }
}
