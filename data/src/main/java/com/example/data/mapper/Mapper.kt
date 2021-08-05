package com.example.data.mapper

import com.example.data.models.Data
import com.example.domain.CryptoDto

fun List<Data>.toDomainModel(): List<CryptoDto> {
    return map {
        CryptoDto(
            id = it.id,
            name = it.name,
            symbol = it.symbol,
            dateAdded = it.dateAdded,
            cmcRank = it.cmcRank,
            logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/${it.id}.png"
        )
    }
}


fun List<CryptoDto>.toEntity(): List<Data> {
    return map {
        Data(
            id = it.id,
            name = it.name,
            symbol = it.symbol,
            dateAdded = it.dateAdded,
            cmcRank = it.cmcRank
        )
    }
}