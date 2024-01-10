package com.example.cardesk.data.repository

import com.example.cardesk.data.network.api.make.MakeApiHelper
import com.example.cardesk.data.network.model.toModel
import com.example.cardesk.domain.model.MakesModel
import com.example.cardesk.domain.repository.GetMakesRepository

class GetMakesRepositoryImpl(private val makeApiHelper: MakeApiHelper): GetMakesRepository {
    override suspend fun getAllMakes(): List<MakesModel> {
        val data = makeApiHelper.getAllMakes()
        return data.map { it.toModel() }
    }
}