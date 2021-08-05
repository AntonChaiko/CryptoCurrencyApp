package com.example.domain

data class CryptoDto(
    val id: Long,
    val name: String,
    val symbol: String,
    val dateAdded: String,
    val cmcRank: Int,
    val logo: String
)