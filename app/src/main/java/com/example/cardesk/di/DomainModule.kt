package com.example.cardesk.di

import com.example.cardesk.domain.usecase.GetAdsByIdUseCase
import com.example.cardesk.domain.usecase.GetAllAdvertisementUseCase
import com.example.cardesk.domain.usecase.GetMakesUseCase
import org.koin.dsl.module


val domainModule = module {
    factory<GetMakesUseCase> { GetMakesUseCase(getMakesRepository = get()) }
    factory<GetAllAdvertisementUseCase> { GetAllAdvertisementUseCase(advertisementRepository = get()) }
    factory<GetAdsByIdUseCase> { GetAdsByIdUseCase(advertisementRepository = get()) }
}