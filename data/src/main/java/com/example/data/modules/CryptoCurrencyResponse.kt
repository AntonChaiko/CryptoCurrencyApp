package com.example.data.modules

import com.squareup.moshi.Json

data class CryptoCurrencyResponse(
    @Json(name = "data")
    val items: List<Data> = emptyList()
)