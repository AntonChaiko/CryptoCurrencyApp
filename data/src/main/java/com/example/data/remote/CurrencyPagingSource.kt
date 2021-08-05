package com.example.data.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.constants.Constants
import com.example.data.mapper.toDomainModel
import com.example.data.remote.api.CryptoCurrencyService
import com.example.domain.CryptoDto
//import com.example.data.constants.DEFAULT_PAGE_SIZE
//import com.example.data.remote.api.ImageApiService
import retrofit2.HttpException
import java.io.IOException


class CurrencyPagingSource(
    private val currencyApiService: CryptoCurrencyService
) : PagingSource<Int, CryptoDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CryptoDto> {
        Log.d("asd", "loaded")

        val position: Int = params.key ?: 1
        val pageSize: Int = params.loadSize

        return try {
            val responseData = currencyApiService.getCryptoCurrency(position, pageSize).items.toDomainModel()

            val nextKey = if (responseData.isEmpty()) {
                null
            } else {
                position + params.loadSize
            }
            LoadResult.Page(
                data = responseData,
                prevKey = if (position == 1) null else position - Constants.MAX_PAGE_SIZE,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CryptoDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(Constants.MAX_PAGE_SIZE)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(Constants.MAX_PAGE_SIZE)
        }

    }
}