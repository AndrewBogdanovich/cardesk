package com.example.cardesk.data.network.model

import com.google.gson.annotations.SerializedName

data class AdvertisementResponse(
    @SerializedName("model") val model: String,
    @SerializedName("generation") val generation: String,
    @SerializedName("city") val city: String,
    @SerializedName("year") val year: String,
    @SerializedName("created") val dateCreating: String,
    @SerializedName("photos") val photos: String,
    @SerializedName("mileage") val mileage: String,
    @SerializedName("engine_volume") val engineVolume: String,
    @SerializedName("transmission") val transmission: String,
    @SerializedName("price") val price: String,
    @SerializedName("body_type") val bodyType: String,
    @SerializedName("mark") val mark: String,
    @SerializedName("engine_type") val engineType: String,
)