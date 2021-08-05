package com.example.cryptocurrency.ui.screens.feedfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.data.repository.CryptoCurrencyRepositoryImpl
import com.example.domain.CryptoDto
import kotlinx.coroutines.flow.Flow

class FeedViewModel(
    private val cryptoCurrencyRepositoryImpl: CryptoCurrencyRepositoryImpl
) :
    ViewModel() {

    private val _data = MutableLiveData<List<CryptoDto>>()
    val cryptoDto: LiveData<List<CryptoDto>>
        get() = _data

    var currentSearchResult: Flow<PagingData<CryptoDto>>? = null


    init {

    }

    fun searchRepo(): Flow<PagingData<CryptoDto>> {
        val lastResult = currentSearchResult
        if (lastResult != null) {
            return lastResult
        }
        val newResult: Flow<PagingData<CryptoDto>> = cryptoCurrencyRepositoryImpl.getSearchResultStream()
            .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }


}