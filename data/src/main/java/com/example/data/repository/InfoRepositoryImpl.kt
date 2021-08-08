package com.example.data.repository

import com.example.data.models.Data
import com.example.data.remote.api.CryptoCurrencyService

class InfoRepositoryImpl(private val cryptoCurrencyService: CryptoCurrencyService) {

    suspend fun getCurrencyInfo(id: Int): MutableMap<String, Data> {
        return cryptoCurrencyService.getCryptoCurrencyInfo(id).data
    }
}