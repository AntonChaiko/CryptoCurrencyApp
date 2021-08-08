package com.example.cryptocurrency.di.module

import com.example.data.repository.CryptoCurrencyRepositoryImpl
import com.example.data.repository.InfoRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoriesModule: Module = module {
    single { CryptoCurrencyRepositoryImpl(get()) }
    single {InfoRepositoryImpl(get())}
}
