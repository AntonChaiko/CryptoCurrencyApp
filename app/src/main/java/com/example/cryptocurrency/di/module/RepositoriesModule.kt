package com.example.cryptocurrency.di.module

import com.example.data.constants.Constants
import com.example.data.remote.api.CryptoCurrencyService
import com.example.data.repository.CryptoCurrencyRepositoryImpl
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.core.context.GlobalContext.get
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoriesModule: Module = module {
    single { provideCryptoCurrencyService(get()) }
}

fun provideCryptoCurrencyRepository(cryptoCurrencyService: CryptoCurrencyService): CryptoCurrencyRepositoryImpl =
    CryptoCurrencyRepositoryImpl(cryptoCurrencyService)