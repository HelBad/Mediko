package com.example.mediabelajarinteraktif.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(
    @SerializedName("id")
    @Expose
    val id: Int = 0,

    @SerializedName("nama")
    @Expose
    val nama: String? = null,

    @SerializedName("username")
    @Expose
    val username: String? = null,

    @SerializedName("no_absen")
    @Expose
    val noAbsen: Int = 0,

    @SerializedName("kelas")
    @Expose
    val kelas: String? = null,

    @SerializedName("user_level")
    @Expose
    val user_level: Int?,

    @SerializedName("mapel")
    @Expose
    val mapel: String? = null,

    @SerializedName("nilai")
    @Expose
    val nilai: Int? = null
)