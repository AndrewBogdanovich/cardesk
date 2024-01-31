package com.example.cardesk.presentation.compose.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.domain.usecase.GetAllAdvertisementUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CarAdsComposeViewModel(private val getAllAdsUseCase: GetAllAdvertisementUseCase) : ViewModel() {

    private val _carAdsState = MutableStateFlow<List<AdvertisementModel>>(emptyList())
    val carAdsState: StateFlow<List<AdvertisementModel>> = _carAdsState.asStateFlow()

    init {
        viewModelScope.launch {
            Log.d("Compose lifecycle", "Vm Inited")
            _carAdsState.value = getAllAdsUseCase.execute()
        }
    }
}