package com.example.cardesk.presentation.advertisement.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CreateAdvertisementViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CreateAdvertisementViewModel() as T
    }
}