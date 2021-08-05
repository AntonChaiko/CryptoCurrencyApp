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
)