package com.example.deezerapp.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.common.extension.downloadFromUrl
import com.example.common.extension.toDurationString
import com.example.deezerapp.R
import com.example.deezerapp.core.DiffCallback
import com.example.deezerapp.databinding.AlbumTracksItemBinding

class FavoritesAdapter(private val onClickFavoriteButton: (FavoriteUiData) -> Unit) :
    RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {
    private var itemList = listOf<FavoriteUiData>()

    inner class FavoritesViewHolder(val binding: AlbumTracksItemBinding) :
        ViewHolder(binding.root) {
        fun bind(favoriteUiData: FavoriteUiData) {
            binding.trackImage.downloadFromUrl(favoriteUiData.picture)
            binding.titleText.text = favoriteUiData.title
            binding.durationText.text = favoriteUiData.duration.toDurationString()
            binding.artistName.text = favoriteUiData.artistName
            binding.favoriteButton.setImageResource(R.drawable.baseline_favorite_24)
            binding.favoriteButton.setOnClickListener {
                onClickFavoriteButton.invoke(favoriteUiData)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val bind =
            AlbumTracksItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoritesViewHolder(bind)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun updateFavoritesAdapterData(newItems: List<FavoriteUiData>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(itemList, newItems))
        itemList = newItems
        diffResult.dispatchUpdatesTo(this)
    }

}