package com.example.data.models

import com.squareup.moshi.Json

data class Data(
    @Json(name = "id")
    val id: Long,
    @Json(name = "name")
    val name: String,
    @Json(name = "symbol")
    val symbol: String,
    @Json(name = "date_added")
    val dateAdded: String,
    @Json(name = "cmc_rank")
    val cmcRank: Int,
    @Json(name = "quote")
    val quote: Quote
)
data class Quote(
    @Json(name = "USD")
    val usd: USD
)

@Json(name = "USD")
data class USD(
    val price: Double,
    @Json(name = "percent_change_1h")
    val percentChange1h : Double,
    @Json(name= "percent_change_24h")
    val percentChange24h: Double,
    @Json(name = "percent_change_7d")
    val percentChange7d: Double,
    )