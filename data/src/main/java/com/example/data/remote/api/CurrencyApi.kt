package com.example.data.remote.api

import androidx.annotation.IntRange
import com.example.data.constants.Constants
import com.example.data.models.CryptoCurrencyResponse
import com.example.data.models.CryptoDetailResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface CryptoCurrencyService {

    @Headers("X-CMC_PRO_API_KEY: ${Constants.API_KEY}")
    @GET("cryptocurrency/listings/latest")
    suspend fun getCryptoCurrency(
        @Query("start") @IntRange(from = 1) page: Int = 1,
        @Query("limit") perPage: Int = Constants.MAX_PAGE_SIZE
    ): CryptoCurrencyResponse

    @Headers("X-CMC_PRO_API_KEY: ${Constants.API_KEY}")
    @GET("cryptocurrency/info")
    suspend fun getCryptoCurrencyInfo(
        @Query("id") id: Int
    ): CryptoDetailResponse

}

