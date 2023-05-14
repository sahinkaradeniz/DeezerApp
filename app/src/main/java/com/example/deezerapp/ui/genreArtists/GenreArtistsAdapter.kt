package com.example.deezerapp.ui.genreArtists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.common.extension.downloadFromUrl
import com.example.deezerapp.databinding.GenreAndArtistItemBinding

class GenreArtistsAdapter(private val onItemClick :(Int)->Unit): RecyclerView.Adapter<GenreArtistsAdapter.GenreArtistsViewHolder>() {
    private val itemList= mutableListOf<GenreArtistsUiData>()
    inner class GenreArtistsViewHolder(private val binding: GenreAndArtistItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(genreArtistsUiData: GenreArtistsUiData){
            binding.itemTitle.text=genreArtistsUiData.name
            binding.itemImage.downloadFromUrl(genreArtistsUiData.picture)
            binding.root.setOnClickListener {
                onItemClick.invoke(genreArtistsUiData.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreArtistsViewHolder {
        val bind= GenreAndArtistItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  GenreArtistsViewHolder(bind)
    }

    override fun onBindViewHolder(holder: GenreArtistsViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    private inner class GenreArtistsDiffCallback(
        private val oldList: List<GenreArtistsUiData>,
        private val newList: List<GenreArtistsUiData>,
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }
    }
    fun updateFavoritesAdapterData(newItems: List<GenreArtistsUiData>) {
        val diffResult = DiffUtil.calculateDiff(GenreArtistsDiffCallback(itemList, newItems))
        itemList.clear()
        itemList.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }
}