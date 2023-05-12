package com.example.deezerapp.ui.favorite

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.common.extension.downloadFromUrl
import com.example.common.extension.formatDuration
import com.example.common.extension.toDurationString
import com.example.deezerapp.R
import com.example.deezerapp.databinding.AlbumTracksItemBinding
import com.example.domain.entity.FavoritesEntity

class FavoritesAdapter(private val onClickFavoriteButton:(FavoritesEntity)->Unit):RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder>() {
    private val itemList= mutableListOf<FavoritesEntity>()
    class FavoritesViewHolder( val binding:AlbumTracksItemBinding):ViewHolder(binding.root) {
        fun bind(favoritesEntity: FavoritesEntity){
            binding.trackImage.downloadFromUrl(favoritesEntity.picture)
            binding.titleText.text=favoritesEntity.title
            binding.durationText.text=favoritesEntity.duration.toDurationString()
            binding.artistName.text=favoritesEntity.artistName
            binding.favoriteButton.setImageResource(R.drawable.baseline_favorite_24)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
       val bind=AlbumTracksItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FavoritesViewHolder(bind)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
       holder.bind(itemList[position])
       holder.binding.favoriteButton.setOnClickListener {
           onClickFavoriteButton.invoke(itemList[position])
       }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newList:List<FavoritesEntity>){
        itemList.clear()
        itemList.addAll(newList)
        notifyDataSetChanged()
    }

}