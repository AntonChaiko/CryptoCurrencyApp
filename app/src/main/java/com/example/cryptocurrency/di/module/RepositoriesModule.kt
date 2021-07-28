package com.example.cryptocurrency.di.module

import com.example.data.repository.CryptoCurrencyRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoriesModule: Module = module {
    single { CryptoCurrencyRepositoryImpl(get()) }
}
