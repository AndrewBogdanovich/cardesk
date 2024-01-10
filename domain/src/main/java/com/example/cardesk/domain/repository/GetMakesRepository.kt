package com.example.cardesk.domain.repository

import com.example.cardesk.domain.model.MakesModel

interface GetMakesRepository {
    suspend fun getAllMakes(): List<MakesModel>
}