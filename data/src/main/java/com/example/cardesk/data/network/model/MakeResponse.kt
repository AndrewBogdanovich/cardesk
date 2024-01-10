package com.example.cardesk.data.network.model

import com.example.cardesk.domain.model.MakesModel
import com.google.gson.annotations.SerializedName

data class MakeResponse(
    @SerializedName("objectId") val id: String,
    @SerializedName("make") val make: String
)

fun MakeResponse.toModel(): MakesModel = MakesModel(make = this.make)
