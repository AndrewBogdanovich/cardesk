package com.example.cardesk.data.network.api.make

import com.example.cardesk.data.network.model.MakeResponse

interface MakeApiHelper {
    suspend fun getAllMakes(): List<MakeResponse>
}