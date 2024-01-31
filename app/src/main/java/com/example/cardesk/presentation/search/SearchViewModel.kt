package com.example.cardesk.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.domain.usecase.GetAllAdvertisementUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class SearchViewModel(private val getAllAdsUseCase: GetAllAdvertisementUseCase) : ViewModel() {
    private val _ads = MutableStateFlow<List<AdvertisementModel>>(emptyList())
    val ads: StateFlow<List<AdvertisementModel>> = _ads.asStateFlow()

    init {
        viewModelScope.launch {
            _ads.emit(getAllAdsUseCase.execute())
        }
    }
}