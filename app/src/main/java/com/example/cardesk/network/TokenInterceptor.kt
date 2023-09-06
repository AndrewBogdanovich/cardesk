package com.example.cardesk.network

import okhttp3.Interceptor
import okhttp3.Response

object TokenInterceptor: Interceptor {
    private const val apiKey = "D00794D6-2FCB-4E06-9848-F042EA47EA47"

    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val url = original.url.newBuilder().addQueryParameter("api-key: ", apiKey).build()
        original = original.newBuilder().url(url).build()
        return chain.proceed(original)
    }
}