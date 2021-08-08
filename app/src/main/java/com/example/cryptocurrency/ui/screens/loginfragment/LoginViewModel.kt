package com.example.cryptocurrency.ui.screens.loginfragment


import androidx.lifecycle.ViewModel
import com.example.data.models.UserEntity
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth


class LoginViewModel(
    val auth: FirebaseAuth,
    val googleSignInClient: GoogleSignInClient
) : ViewModel() {

    fun setUserEntity(): UserEntity {
        auth.currentUser.let {
            return UserEntity(
                userEmail = it?.email.toString(),
                userName = it?.displayName.toString(),
                userImage = it?.photoUrl,
            )
        }

    }
    fun signOut() {
        googleSignInClient.signOut()
        auth.signOut()
    }
}