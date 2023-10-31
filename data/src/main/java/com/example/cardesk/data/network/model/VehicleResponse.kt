package com.example.cardesk.data.network.model

import com.google.gson.annotations.SerializedName

data class VehicleResponse(
    @SerializedName("objectId")
    val id: String,
    @SerializedName("mark")
    val mark: String,
    @SerializedName("model")
    val model: String,
    @SerializedName("generation")
    val generation: String,
    @SerializedName("image_url")
    val imageUrl: String
)
