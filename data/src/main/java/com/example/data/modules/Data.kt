package com.example.data.modules

import com.squareup.moshi.Json

data class Data(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String,
    @Json(name = "symbol")
    val symbol: String,
)