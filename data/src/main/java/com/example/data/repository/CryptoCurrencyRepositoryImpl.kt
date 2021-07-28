package com.example.data.repository

import com.example.data.modules.Data
import com.example.data.remote.api.CryptoCurrencyService

class CryptoCurrencyRepositoryImpl(val cryptoCurrencyService: CryptoCurrencyService) {
    suspend fun getData(): List<Data> {
        return cryptoCurrencyService.getCryptoCurrency().items
    }
}