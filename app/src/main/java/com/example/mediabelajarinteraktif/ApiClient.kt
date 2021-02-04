package com.example.mediabelajarinteraktif

import com.example.mediabelajarinteraktif.model.Soal
import com.example.mediabelajarinteraktif.model.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

class ApiClient {

    private fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    private fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://ninofachrurozy.com/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService(): Services = getRetrofit().create(Services::class.java)
}

interface Services {
    @POST("login")
    @FormUrlEncoded
    fun login(@Field("username") username: String): Call<User>

    @POST("soal")
    @FormUrlEncoded
    fun getSoal(): Call<List<Soal>>

    @POST("soal")
    @FormUrlEncoded
    fun getSoalSingle(@Field("id") id: Int): Call<Soal>

    @POST("add_soal")
    @FormUrlEncoded
    fun addSoal(
        @Field("soal") soal: String,
        @Field("a") pilihanA: String,
        @Field("b") pilihanB: String,
        @Field("c") pilihanC: String,
        @Field("d") pilihanD: String,
        @Field("e") pilihanE: String,
        @Field("benar") benar: Int
    ): Call<String>

    @POST("edit_soal")
    @FormUrlEncoded
    fun editSoal(
        @Field("id") id: Int,
        @Field("soal") soal: String,
        @Field("a") pilihanA: String,
        @Field("b") pilihanB: String,
        @Field("c") pilihanC: String,
        @Field("d") pilihanD: String,
        @Field("e") pilihanE: String,
        @Field("benar") benar: Int
    ): Call<String>

    @POST("delete_soal")
    @FormUrlEncoded
    fun deleteSoal(@Field("id") id: Int): Call<String>

    @POST("user")
    @FormUrlEncoded
    fun getUser(@Field("id") id: Int): Call<User>

    @POST("nilai")
    @FormUrlEncoded
    fun getNilai(): Call<List<User>>

    @POST("submit_nilai")
    @FormUrlEncoded
    fun submitNilai(
        @Field("id") id: Int,
        @Field("nilai") nilai: Int
    ): Call<String>
}