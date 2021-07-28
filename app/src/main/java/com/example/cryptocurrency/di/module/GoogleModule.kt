package com.example.cryptocurrency.di.module

import com.example.data.constants.Constants
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.core.module.Module
import org.koin.dsl.module

val googleModule: Module = module {

    single { provideGoogleSignInOptions() }
    single { provideFirebaseAuth() }

}

fun provideGoogleSignInOptions(): GoogleSignInOptions {
    return GoogleSignInOptions
        .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(Constants.WEB_CLIENT_ID)
        .requestEmail()
        .build()
}

fun provideFirebaseAuth(): FirebaseAuth = Firebase.auth
