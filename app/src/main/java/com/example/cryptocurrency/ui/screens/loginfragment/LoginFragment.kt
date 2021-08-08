package com.example.cryptocurrency.ui.screens.loginfragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.LoginFragmentBinding
import com.example.cryptocurrency.ui.base.BaseFragment
import com.example.data.constants.Constants
import com.example.data.models.UserEntity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.GoogleAuthProvider
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<LoginFragmentBinding>() {

    private val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signInButton.setOnClickListener { signIn() }

    }

    override fun onStart() {
        super.onStart()
        if (viewModel.auth.currentUser != null) {
            val action = LoginFragmentDirections.actionLoginFragmentToFeedFragment(viewModel.setUserEntity())
            findNavController().navigate(action)
        }
    }

    private fun signIn() {
        startActivityForResult(viewModel.googleSignInClient.signInIntent, Constants.RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        checkUser(requestCode, data)
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        viewModel.auth.signInWithCredential(credential)

        val action = LoginFragmentDirections.actionLoginFragmentToFeedFragment(viewModel.setUserEntity())
        findNavController().navigate(action)

    }

    private fun checkUser(requestCode: Int, data: Intent?) {
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

    override fun getFragmentView(): Int = R.layout.login_fragment

}



