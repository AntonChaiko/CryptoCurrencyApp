package com.example.cryptocurrency.ui.screens.feedfragment

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.data.models.UserEntity
import com.example.data.repository.CryptoCurrencyRepositoryImpl
import com.example.domain.CryptoDto
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow

class FeedViewModel(
    private val cryptoCurrencyRepositoryImpl: CryptoCurrencyRepositoryImpl,
    private val googleSignInClient: GoogleSignInClient,
    private val auth: FirebaseAuth
) :
    ViewModel() {

    var currentSearchResult: Flow<PagingData<CryptoDto>>? = null
//    val currentUser: MutableLiveData<UserEntity> = MutableLiveData(setUserEntity())

    fun searchRepo(): Flow<PagingData<CryptoDto>> {
        val lastResult = currentSearchResult

        if (lastResult != null) return lastResult

        val newResult: Flow<PagingData<CryptoDto>> =
            cryptoCurrencyRepositoryImpl.getSearchResultStream()
                .cachedIn(viewModelScope)

        currentSearchResult = newResult
        return newResult
    }

    fun checkPrice(price: Double): Int {
        return if (price >= 0) Color.BLUE else Color.RED
    }

//    fun setUserEntity(): UserEntity {
//        auth.currentUser.let {
//            return UserEntity(
//                userEmail = it?.email.toString(),
//                userName = it?.displayName.toString(),
//                userImage = it?.photoUrl,
//            )
//        }
//
//    }

    fun signOut() {
        googleSignInClient.signOut()
        auth.signOut()
    }
}