package com.example.cardesk.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardesk.data.network.RetrofitClient
import com.example.cardesk.data.network.api.advertisement.AdvertisementApiHelperImpl
import com.example.cardesk.data.network.model.AdvertisementResponse
import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.domain.usecase.GetAdsByIdUseCase
import com.example.cardesk.domain.usecase.GetAllAdvertisementUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class AdvertisementDetailViewModel(private val getAdsByIdUseCase: GetAdsByIdUseCase) :
    ViewModel() {

    private val _adById =
        MutableSharedFlow<List<AdvertisementModel>>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val adById = _adById.asSharedFlow()

    suspend fun getAd(id: String) {
        _adById.emit(getAdsByIdUseCase.execute(id))
    }
}