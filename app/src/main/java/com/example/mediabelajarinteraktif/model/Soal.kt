package com.example.mediabelajarinteraktif.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Soal (
    @SerializedName("id")
    @Expose
    val id: Int = 0,

    @SerializedName("soal")
    @Expose
    val soal: String? = null,

    @SerializedName("pilihan")
    @Expose
    val pilihan: List<Pilihan>? = null
) : Parcelable