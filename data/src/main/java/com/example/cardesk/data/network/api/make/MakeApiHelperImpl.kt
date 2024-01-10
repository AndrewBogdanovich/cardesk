package com.example.cardesk.data.network.api.make

import com.example.cardesk.data.network.model.MakeResponse

class MakeApiHelperImpl(private val makeApiService: MakeApiService) : MakeApiHelper {
    override suspend fun getAllMakes(): List<MakeResponse> =
        makeApiService.getAllMakes()
}
