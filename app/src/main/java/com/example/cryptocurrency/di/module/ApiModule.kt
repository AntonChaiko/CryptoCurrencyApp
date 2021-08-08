package com.example.cryptocurrency.di.module

import com.example.data.constants.Constants
import com.example.data.remote.api.CryptoCurrencyService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val apiModule: Module = module {
    single { provideMoshi() }
    single { provideRetrofit(get()) }
    single { provideCryptoCurrencyService(get()) }
}

fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}

fun provideRetrofit(moshi: Moshi): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(Constants.BASE_URL)
        .build()
}

fun provideCryptoCurrencyService(retrofit: Retrofit): CryptoCurrencyService =
    retrofit.create(CryptoCurrencyService::class.java)