package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.constants.Constants
import com.example.data.models.Data
import com.example.data.remote.CurrencyPagingSource
import com.example.data.remote.api.CryptoCurrencyService
import com.example.domain.CryptoDto
import kotlinx.coroutines.flow.Flow

class CryptoCurrencyRepositoryImpl(private val cryptoCurrencyService: CryptoCurrencyService) {

    fun getSearchResultStream(): Flow<PagingData<CryptoDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.MAX_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CurrencyPagingSource(cryptoCurrencyService)
            }
        ).flow
    }
    

}