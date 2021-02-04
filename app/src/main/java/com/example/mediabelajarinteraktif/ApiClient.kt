package com.example.mediabelajarinteraktif

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://ninofachrurozy.com/")
        .client(getInterceptor())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService(): Services = retrofit.create(Services::class.java)
}