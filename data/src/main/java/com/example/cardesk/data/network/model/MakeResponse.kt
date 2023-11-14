package com.example.cardesk.data.network.model

import com.google.gson.annotations.SerializedName

data class MakeResponse(
    @SerializedName("objectId") val id: String,
    @SerializedName("make") val make: String
)
