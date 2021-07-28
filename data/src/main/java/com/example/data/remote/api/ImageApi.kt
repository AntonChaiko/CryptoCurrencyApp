package com.example.data.remote.api

import com.example.data.constants.Constants
import com.example.data.modules.CryptoCurrencyResponse
import retrofit2.http.GET

import retrofit2.http.Headers


interface CryptoCurrencyService {

    @Headers("X-CMC_PRO_API_KEY: ${Constants.API_KEY}")
    @GET("cryptocurrency/listings/latest")
    suspend fun getCryptoCurrency(): CryptoCurrencyResponse
}

