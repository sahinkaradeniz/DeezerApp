package com.example.deezerapp.ui.genres

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.common.extension.downloadFromUrl
import com.example.deezerapp.databinding.GenreAndArtistItemBinding

class GenresAdapter(private val onItemClick :(Int,String)->Unit):RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {
    private val itemList= mutableListOf<GenresUiData>()
    class GenresViewHolder(private val binding:GenreAndArtistItemBinding):ViewHolder(binding.root) {
        fun bind(genresUiData: GenresUiData){
            binding.itemTitle.text=genresUiData.name
            binding.itemImage.downloadFromUrl(genresUiData.picture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val bind=GenreAndArtistItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GenresViewHolder(bind)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
       holder.bind(itemList[position])
       holder.itemView.setOnClickListener {
           onItemClick.invoke(itemList[position].id,itemList[position].name)
       }
    }

    override fun getItemCount(): Int {
       return itemList.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newItems: List<GenresUiData>) {
        itemList.clear()
        itemList.addAll(newItems)
        notifyDataSetChanged()
    }


}