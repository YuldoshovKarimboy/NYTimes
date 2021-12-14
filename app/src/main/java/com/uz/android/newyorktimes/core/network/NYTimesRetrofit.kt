package com.uz.android.newyorktimes.core.network

import com.uz.android.newyorktimes.core.base_url
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NYTimesRetrofit {

    fun api(): NYTimesApi = retrofit().create(NYTimesApi::class.java)

    private fun retrofit(): Retrofit =
        Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create())
            .client(client()).build()

    private fun client(): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor()).build()

    private fun interceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
}