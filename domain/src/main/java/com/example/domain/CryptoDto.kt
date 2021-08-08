package com.example.domain

data class CryptoDto(
    val id: Long,
    val name: String,
    val symbol: String,
    val dateAdded: String,
    val cmcRank: Int,
    val logo: String,
    val price: Double?,
    val percentChange1h: Double,
    val percentChange24h: Double,
    val percentChange7d: Double,
)