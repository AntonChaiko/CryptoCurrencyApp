package com.example.cryptocurrency.ui.screens.feedfragment

import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.example.cryptocurrency.databinding.FeedFragmentBinding
import com.example.cryptocurrency.ui.base.BaseFragment
import com.example.cryptocurrency.ui.screens.feedfragment.adapters.FeedAdapter
import com.example.cryptocurrency.ui.screens.feedfragment.adapters.FeedLoaderStateAdapter
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.cryptocurrency.R
import com.example.data.mapper.userEntityToDto
import com.example.data.models.UserEntity
import com.example.domain.UserDto

import com.google.android.material.navigation.NavigationView


class FeedFragment : BaseFragment<FeedFragmentBinding>() {

    private val viewModel: FeedViewModel by viewModel()
    private val adapter by lazy {
        FeedAdapter { price -> viewModel.checkPrice(price) }
    }
    private var searchJob: Job? = null
    private val args: FeedFragmentArgs by navArgs()


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val connectivityManager =
            getSystemService(requireContext(), ConnectivityManager::class.java)

        binding.lifecycleOwner = this

        binding.feedRecyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
            footer = FeedLoaderStateAdapter(),
            header = FeedLoaderStateAdapter()
        )
        searchCurrency()

        adapter.addLoadStateListener { state: CombinedLoadStates ->
            binding.feedRecyclerView.isVisible = state.refresh != LoadState.Loading
            binding.progress.isVisible = state.refresh == LoadState.Loading
        }

        connectivityManager?.registerDefaultNetworkCallback(object :
            ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                adapter.refresh()
            }
        })

    }

    private fun searchCurrency() {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewModel.searchRepo().collectLatest(adapter::submitData)
        }
    }


    override fun getFragmentView(): Int = R.layout.feed_fragment

}