package com.example.exchangeapp.api

import com.example.exchangeapp.data.ExchangeRate
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyAPI {
    @GET("/NBUStatService/v1/statdirectory/exchange?json")
    suspend fun getExchangeRateList(): Response<List<ExchangeRate>>

    @GET("/NBUStatService/v1/statdirectory/exchange?json")
    suspend fun getExchangeRate(@Query("valcode") valcode: String): Response<List<ExchangeRate>>
}

