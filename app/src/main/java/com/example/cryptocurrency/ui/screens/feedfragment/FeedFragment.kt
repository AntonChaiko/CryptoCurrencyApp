package com.example.cryptocurrency.ui.screens.feedfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.FeedFragmentBinding
import com.example.cryptocurrency.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class FeedFragment : BaseFragment<FeedFragmentBinding>() {

    private val viewModel: FeedViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.testApiCallButton.setOnClickListener {
            viewModel.data.forEach {
                Log.d("asd", it.name)
            }
        }
    }

    override fun getFragmentView(): Int = R.layout.feed_fragment

}