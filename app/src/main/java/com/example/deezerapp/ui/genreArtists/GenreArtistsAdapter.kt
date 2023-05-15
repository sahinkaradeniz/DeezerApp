package com.example.deezerapp.ui.genreArtists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.common.extension.downloadFromUrl
import com.example.deezerapp.core.DiffCallback
import com.example.deezerapp.databinding.GenreAndArtistItemBinding

class GenreArtistsAdapter(private val onItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<GenreArtistsAdapter.GenreArtistsViewHolder>() {
    private var itemList = listOf<GenreArtistsUiData>()

    inner class GenreArtistsViewHolder(private val binding: GenreAndArtistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(genreArtistsUiData: GenreArtistsUiData) {
            binding.itemTitle.text = genreArtistsUiData.name
            binding.itemImage.downloadFromUrl(genreArtistsUiData.picture)
            binding.root.setOnClickListener {
                onItemClick.invoke(genreArtistsUiData.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreArtistsViewHolder {
        val bind =
            GenreAndArtistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenreArtistsViewHolder(bind)
    }

    override fun onBindViewHolder(holder: GenreArtistsViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun updateFavoritesAdapterData(newItems: List<GenreArtistsUiData>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(itemList, newItems))
        itemList = newItems
        diffResult.dispatchUpdatesTo(this)
    }
}