package com.example.deezerapp.ui.genreArtists

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.common.extension.downloadFromUrl
import com.example.deezerapp.databinding.GenreAndArtistItemBinding

class GenreArtistsAdapter(private val onItemClick :(Int)->Unit): RecyclerView.Adapter<GenreArtistsAdapter.GenreArtistsViewHolder>() {
    private val itemList= mutableListOf<GenreArtistsUiData>()
    class GenreArtistsViewHolder(private val binding: GenreAndArtistItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(genreArtistsUiData: GenreArtistsUiData){
            binding.itemTitle.text=genreArtistsUiData.name
            binding.itemImage.downloadFromUrl(genreArtistsUiData.picture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreArtistsViewHolder {
        val bind= GenreAndArtistItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  GenreArtistsViewHolder(bind)
    }

    override fun onBindViewHolder(holder: GenreArtistsViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.itemView.setOnClickListener {
            onItemClick.invoke(itemList[position].id)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newItems: List<GenreArtistsUiData>) {
        itemList.clear()
        itemList.addAll(newItems)
        notifyDataSetChanged()
    }


}