package com.example.cardesk.data.transformer

import com.example.cardesk.data.network.model.AdvertisementRequest
import com.example.cardesk.data.network.model.AdvertisementResponse
import com.example.cardesk.domain.model.AdvertisementModel

object AdvertisementTransformer {

    fun transformToModel(networkModel: AdvertisementRequest): AdvertisementModel = AdvertisementModel(
        id = null,
        bodyType = networkModel.bodyType,
        city = networkModel.city,
        color = networkModel.color,
        dateCreating = networkModel.dateCreating,
        make = networkModel.make,
        mileage = networkModel.mileage,
        description = networkModel.description,
        engineType = networkModel.engineType,
        model = networkModel.model,
        photos = networkModel.photos,
        price = networkModel.price,
        year = networkModel.year,
        transmission = networkModel.transmission,
        engineVolume = networkModel.engineVolume,
        generation = networkModel.generation
    )

    fun transformToModel(networkModel: AdvertisementResponse): AdvertisementModel = AdvertisementModel(
        id = networkModel.id,
        bodyType = networkModel.bodyType,
        city = networkModel.city,
        color = networkModel.color,
        dateCreating = networkModel.dateCreating,
        make = networkModel.make,
        mileage = networkModel.mileage,
        description = networkModel.description,
        engineType = networkModel.engineType,
        model = networkModel.model,
        photos = networkModel.photos,
        price = networkModel.price,
        year = networkModel.year,
        transmission = networkModel.transmission,
        engineVolume = networkModel.engineVolume,
        generation = networkModel.generation
    )
}