package com.example.exchangeapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exchangeapp.api.CurrencyAPI
import com.example.exchangeapp.api.RetrofitService
import com.example.exchangeapp.data.ExchangeRate

import kotlinx.coroutines.launch

class CurrencyRateListViewModel : ViewModel() {

    private val posts = MutableLiveData<List<ExchangeRate>>()

    init {
        viewModelScope.launch {
            val retrofit = RetrofitService.getInstance()
            val apiInterface = retrofit.create(CurrencyAPI::class.java)
            val response = apiInterface.getExchangeRateList()

            try {
                val data = response.body()
                posts.value = data?.let { it }
            } catch (ex: NullPointerException) {
                ex.printStackTrace()
            }
        }
    }

    fun getCurrencyRateList() = posts
}