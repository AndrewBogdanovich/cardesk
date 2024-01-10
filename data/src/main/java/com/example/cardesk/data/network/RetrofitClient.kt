package com.example.cardesk.data.network

import com.example.cardesk.data.network.api.advertisement.AdvertisementApiService
import com.example.cardesk.data.network.api.make.MakeApiService
import com.example.cardesk.data.network.api.vehicle.VehicleApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {

    private const val baseUrl = "https://subtlearm.backendless.app/"

    private fun getRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun getOkHttpClient(): OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(TokenInterceptor).build()

    val vehicleApiService: VehicleApiService =
        getRetrofitInstance().create(VehicleApiService::class.java)

    val advertisementApiService: AdvertisementApiService =
        getRetrofitInstance().create(AdvertisementApiService::class.java)

    val makeApiService: MakeApiService = getRetrofitInstance().create(MakeApiService::class.java)
}