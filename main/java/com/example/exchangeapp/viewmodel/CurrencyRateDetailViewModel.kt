package com.example.exchangeapp.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangeapp.api.CurrencyAPI
import com.example.exchangeapp.api.RetrofitService
import com.example.exchangeapp.data.ExchangeRate

import kotlinx.coroutines.launch

class CurrencyRateDetailViewModel : ViewModel() {

    val post = MutableLiveData<ExchangeRate>()

    fun getExchangeRate(valcode: String) {
        viewModelScope.launch {
            try {
                val retrofit = RetrofitService.getInstance()
                val apiInterface = retrofit.create(CurrencyAPI::class.java)

                val response = apiInterface.getExchangeRate(valcode)
                if (response.isSuccessful) {
                    val data = response.body() ?: throw NullPointerException("Post is null")
                    post.value = data.get(0)
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}