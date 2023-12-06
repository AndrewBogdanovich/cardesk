package com.example.cardesk.data.network.model

import com.example.cardesk.domain.model.AdvertisementModel
import com.google.gson.annotations.SerializedName

data class AdvertisementResponse(
    @SerializedName("objectId") val id: String,
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
    @SerializedName("make") val make: String,
    @SerializedName("engine_type") val engineType: String,
    @SerializedName("description") val description: String,
    @SerializedName("color") val color: String,
)

fun AdvertisementResponse.toModel(): com.example.cardesk.domain.model.AdvertisementModel =
    com.example.cardesk.domain.model.AdvertisementModel(
        id = this.id,
        model = this.model,
        generation = this.generation,
        city = this.city,
        year = this.year,
        dateCreating = this.dateCreating,
        photos = this.photos,
        mileage = this.mileage,
        engineVolume = this.engineVolume,
        transmission = this.transmission,
        price = this.price,
        bodyType = this.bodyType,
        make = this.make,
        engineType = this.engineType,
        description = this.description,
        color = this.color
    )