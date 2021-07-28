package com.example.cryptocurrency.ui.screens.feedfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrency.utils.LoadingState
import com.example.data.modules.Data
import com.example.data.repository.CryptoCurrencyRepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FeedViewModel(
    val cryptoCurrencyRepositoryImpl: CryptoCurrencyRepositoryImpl
) :
    ViewModel(), Callback<List<Data>> {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    private val _data = MutableLiveData<List<Data>>()
    val data: LiveData<List<Data>>
        get() = _data

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _data.value = cryptoCurrencyRepositoryImpl.getData()
        }
    }

    override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
        if (response.isSuccessful) {
            _data.postValue(response.body())
            _loadingState.postValue(LoadingState.LOADED)
            Log.d("asd", "success")
        } else {
            _loadingState.postValue(LoadingState.error(response.errorBody().toString()))
        }
    }

    override fun onFailure(call: Call<List<Data>>, t: Throwable) =
        _loadingState.postValue(LoadingState.error(t.message))



}