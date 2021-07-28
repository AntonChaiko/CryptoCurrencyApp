package com.example.cryptocurrency.ui.screens.feedfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.modules.Data
import com.example.data.repository.CryptoCurrencyRepositoryImpl
import kotlinx.coroutines.launch

class FeedViewModel( val cryptoCurrencyRepositoryImpl: CryptoCurrencyRepositoryImpl) : ViewModel() {

    var data: List<Data> = emptyList()

    init{
        getData()
    }
    private fun getData() {
        viewModelScope.launch {
            data = cryptoCurrencyRepositoryImpl.getData()
        }
    }

}