package com.example.mediabelajarinteraktif.api

import com.example.mediabelajarinteraktif.model.Soal
import com.example.mediabelajarinteraktif.model.Status
import com.example.mediabelajarinteraktif.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Services {
    @POST("login")
    @FormUrlEncoded
    fun login(@Field("username") username: String): Call<User>

    @POST("soal")
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
    ): Call<Status>

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
    ): Call<Status>

    @POST("delete_soal")
    @FormUrlEncoded
    fun deleteSoal(@Field("id") id: Int): Call<Status>

    @POST("user")
    @FormUrlEncoded
    fun getUser(@Field("id") id: Int): Call<User>

    @POST("nilai")
    fun getNilai(): Call<List<User>>

    @POST("submit_nilai")
    @FormUrlEncoded
    fun submitNilai(
        @Field("id") id: Int,
        @Field("nilai") nilai: Int,
        @Field("nama") nama: String,
        @Field("no_absen") noAbsen: String,
        @Field("kelas") kelas: String
    ): Call<Status>
}