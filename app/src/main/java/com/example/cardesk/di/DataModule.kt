package com.example.cardesk.di

import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.api.advertisement.AdvertisementApiHelper
import com.example.cardesk.data.network.api.advertisement.AdvertisementApiHelperImpl
import com.example.cardesk.data.network.api.make.MakeApiHelper
import com.example.cardesk.data.network.api.make.MakeApiHelperImpl
import com.example.cardesk.data.repository.AdvertisementRepositoryImpl
import com.example.cardesk.data.repository.GetMakesRepositoryImpl
import com.example.cardesk.domain.repository.AdvertisementRepository
import com.example.cardesk.domain.repository.GetMakesRepository
import org.koin.dsl.module


val dataModule = module {

    single<MakeApiHelper> { MakeApiHelperImpl(makeApiService = RetrofitClient.makeApiService) }
    single<GetMakesRepository> { GetMakesRepositoryImpl(makeApiHelper = get()) }

    single<AdvertisementApiHelper> { AdvertisementApiHelperImpl(advertisementApiService = RetrofitClient.advertisementApiService) }
    single<AdvertisementRepository> { AdvertisementRepositoryImpl(advertisementApiHelper = get()) }
}
