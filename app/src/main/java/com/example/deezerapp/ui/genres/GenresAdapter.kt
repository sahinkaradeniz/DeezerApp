package com.example.deezerapp.ui.genres

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.common.extension.downloadFromUrl
import com.example.deezerapp.core.DiffCallback
import com.example.deezerapp.databinding.GenreAndArtistItemBinding

class GenresAdapter(private val onItemClick :(Int,String)->Unit):RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {
    private var itemList= listOf<GenresUiData>()
    inner class GenresViewHolder(private val binding:GenreAndArtistItemBinding):ViewHolder(binding.root) {
        fun bind(genresUiData: GenresUiData){
            binding.itemTitle.text=genresUiData.name
            binding.itemImage.downloadFromUrl(genresUiData.picture)
            binding.root.setOnClickListener {
                onItemClick.invoke(genresUiData.id,genresUiData.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val bind=GenreAndArtistItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GenresViewHolder(bind)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
       holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
       return itemList.size
    }
    fun updateGenresAdapterData(newItems: List<GenresUiData>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(itemList, newItems))
        itemList=newItems
        diffResult.dispatchUpdatesTo(this)
    }

}