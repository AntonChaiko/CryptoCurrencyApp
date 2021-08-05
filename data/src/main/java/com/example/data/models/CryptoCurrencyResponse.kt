package com.example.data.models

import com.squareup.moshi.Json

data class CryptoCurrencyResponse(
    @Json(name = "data")
    val items: List<Data> = emptyList()
)

