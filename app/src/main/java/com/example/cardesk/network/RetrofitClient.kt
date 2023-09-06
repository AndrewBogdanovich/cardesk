package com.example.cardesk.network

import com.example.cardesk.network.api.VehicleApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
}