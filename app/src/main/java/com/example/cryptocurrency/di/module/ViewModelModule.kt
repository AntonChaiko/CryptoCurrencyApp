package com.example.cryptocurrency.di.module

import com.example.cryptocurrency.ui.screens.loginfragment.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {  LoginViewModel(get(), get()) }

}