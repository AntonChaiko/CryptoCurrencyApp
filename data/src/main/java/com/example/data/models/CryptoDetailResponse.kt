package com.example.data.models

import com.squareup.moshi.Json

data class CryptoDetailResponse(
    @Json(name = "data")
    val data: MutableMap<String, Data>,
)
