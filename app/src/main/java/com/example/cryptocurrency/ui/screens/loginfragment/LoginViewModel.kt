package com.example.cryptocurrency.ui.screens.loginfragment


import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.data.constants.Constants
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider


class LoginViewModel(
    val googleSignInOptions: GoogleSignInOptions,
    val auth: FirebaseAuth
) : ViewModel() {

    fun checkUser(requestCode:Int,data: Intent?) {
        if (requestCode == Constants.RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Log.d("asd", "Google sign in failed", e)
            }
        }

    }
     private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
    }

}