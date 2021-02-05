package com.example.mediabelajarinteraktif.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Status (
    @SerializedName("status")
    @Expose
    val status: String? = null
)