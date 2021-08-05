package com.example.data.models

import com.squareup.moshi.Json

data class CryptoDetailResponse(
    @Json(name = "data")
    val data: MutableMap<String, Data>,
)

/*
internal fun CryptoDetailResponse.mapToCryptoDetail(): Data {
    val coin = this.data.values.first()
    return Data(
        logo = coin.logo,
        description = coin.description,
    )
}*/
