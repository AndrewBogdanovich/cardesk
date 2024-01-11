package com.example.cardesk.domain.usecase

import com.example.cardesk.domain.model.MakesModel
import com.example.cardesk.domain.repository.GetMakesRepository

class GetMakesUseCase(private val getMakesRepository: GetMakesRepository) {
    suspend fun execute(): List<MakesModel>{
        return getMakesRepository.getAllMakes()
    }
}