package com.example.cardesk.di

import com.example.cardesk.presentation.advertisement.create.CreateAdvertisementViewModel
import com.example.cardesk.presentation.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<SearchViewModel> { SearchViewModel(getAllAdsUseCase = get()) }
    viewModel<CreateAdvertisementViewModel> { CreateAdvertisementViewModel(getMakesUseCase = get()) }
}