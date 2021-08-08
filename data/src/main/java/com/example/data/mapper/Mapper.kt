package com.example.data.mapper

import com.example.data.models.Data
import com.example.data.models.Quote
import com.example.data.models.USD
import com.example.domain.CryptoDto

fun List<Data>.toDomainModel(): List<CryptoDto> {
    return map {
        CryptoDto(
            id = it.id,
            name = it.name,
            symbol = it.symbol,
            dateAdded = it.dateAdded,
            cmcRank = it.cmcRank,
            logo = "https://s2.coinmarketcap.com/static/img/coins/64x64/${it.id}.png",
            price = it.quote.usd.price,
            percentChange1h = it.quote.usd.percentChange1h,
            percentChange7d = it.quote.usd.percentChange7d,
            percentChange24h = it.quote.usd.percentChange24h

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
            cmcRank = it.cmcRank,
            quote = Quote(USD(1.1, 1.1, 1.1, 1.1))
        )
    }
}