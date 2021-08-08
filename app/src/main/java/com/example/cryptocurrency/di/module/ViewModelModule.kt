package com.example.cryptocurrency.di.module

import com.example.cryptocurrency.ui.screens.feedfragment.FeedViewModel
import com.example.cryptocurrency.ui.screens.loginfragment.LoginViewModel
import com.example.data.repository.CryptoCurrencyRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {  LoginViewModel(get(), get()) }
    viewModel { FeedViewModel(get(),get(),get()) }
}