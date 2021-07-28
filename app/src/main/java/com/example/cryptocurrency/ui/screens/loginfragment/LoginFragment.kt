package com.example.cryptocurrency.ui.screens.loginfragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.LoginFragmentBinding
import com.example.cryptocurrency.ui.base.BaseFragment
import com.example.data.constants.Constants
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<LoginFragmentBinding>() {

    private val viewModel: LoginViewModel by viewModel()

    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        googleSignInClient = GoogleSignIn.getClient(
            requireActivity(),
            viewModel.googleSignInOptions
        )

        binding.signInButton.setOnClickListener { signIn() }
        binding.logOutButton.setOnClickListener { signOut() }

    }

    private fun signOut() {
        googleSignInClient.signOut()
        viewModel.auth.signOut()
    }

    private fun signIn() {
        startActivityForResult(googleSignInClient.signInIntent, Constants.RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.checkUser(requestCode, data)
    }


    override fun getFragmentView(): Int = R.layout.login_fragment

}



