package com.example.cardesk.presentation.advertisement.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardesk.domain.model.MakesModel
import com.example.cardesk.domain.usecase.GetMakesUseCase
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class CreateAdvertisementViewModel(private val getMakesUseCase: GetMakesUseCase) : ViewModel() {

    private val _makes = MutableSharedFlow<List<MakesModel>>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val makes: SharedFlow<List<MakesModel>> = _makes.asSharedFlow()

    init {
        viewModelScope.launch {
            _makes.emit(loadMakes())
        }
    }

    private suspend fun loadMakes(): List<MakesModel> = getMakesUseCase.execute()
}