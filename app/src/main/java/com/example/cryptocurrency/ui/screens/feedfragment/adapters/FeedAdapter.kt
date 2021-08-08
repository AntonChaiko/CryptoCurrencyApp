package com.example.cryptocurrency.ui.screens.feedfragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.R
import com.example.cryptocurrency.databinding.FeedItemViewBinding
import com.example.domain.CryptoDto

class FeedAdapter(
    val checkPrice: (price: Double) -> Int
) :
    PagingDataAdapter<CryptoDto, FeedAdapter.ImagesViewHolder>(ArticleDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_item_view, parent, false)
        return ImagesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ImagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = FeedItemViewBinding.bind(itemView)
        fun bind(cryptoDto: CryptoDto?) = with(itemView) {
            binding.cryptoDto = cryptoDto

            if (cryptoDto != null) {
                binding.priceHourTextView.setTextColor(checkPrice(cryptoDto.percentChange1h))
                binding.priceDayTextView.setTextColor(checkPrice(cryptoDto.percentChange24h))
                binding.priceWeekTextView.setTextColor(checkPrice(cryptoDto.percentChange7d))
            }
        }
    }


    private object ArticleDiffItemCallback : DiffUtil.ItemCallback<CryptoDto>() {

        override fun areItemsTheSame(oldItem: CryptoDto, newItem: CryptoDto): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CryptoDto, newItem: CryptoDto): Boolean {
            return oldItem.id == newItem.id
        }
    }
}