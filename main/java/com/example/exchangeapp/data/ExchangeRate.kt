package com.example.exchangeapp.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ExchangeRate (
    @SerializedName("txt")
    var txt: String,

    @SerializedName("rate")
    var rate: Double,

    @SerializedName("cc")
    var cc: String,

    @SerializedName("exchangedate")
    var exchangeDate: String,

    ) : Serializable

