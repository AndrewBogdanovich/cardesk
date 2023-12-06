package com.example.cardesk.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardesk.domain.model.AdvertisementModel
import com.example.cardesk.domain.usecase.GetAllAdvertisementUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SearchViewModel(private val getAllAdsUSeCase: GetAllAdvertisementUseCase) : ViewModel() {
    private val _ads = MutableSharedFlow<List<AdvertisementModel>>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val ads: SharedFlow<List<AdvertisementModel>> = _ads.asSharedFlow()

    init {
        viewModelScope.launch {
            _ads.emit(getAllAdsUSeCase.execute())
        }
    }

    fun update(){

    }

    override fun onCleared() {
        super.onCleared()
    }
}