package com.example.cardesk.domain.usecase

import com.example.cardesk.domain.model.MakesModel
import com.example.cardesk.domain.repository.GetMakesRepository

class GetMakesUseCase(private val repo: GetMakesRepository) {
    suspend fun execute(): List<MakesModel>{
        return repo.getAllMakes()
    }
}