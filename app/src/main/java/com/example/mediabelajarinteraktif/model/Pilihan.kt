package com.example.mediabelajarinteraktif.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pilihan (
    @SerializedName("id")
    @Expose
    val id: Int = 0,

    @SerializedName("pilihan")
    @Expose
    val pilihan: String? = null,

    @SerializedName("is_benar")
    @Expose
    val isBenar: Int = 0,

    @SerializedName("id_soal")
    @Expose
    val idSoal: Int = 0
) : Parcelable