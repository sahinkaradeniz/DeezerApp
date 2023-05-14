package com.example.deezerapp.ui.genres

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.common.extension.downloadFromUrl
import com.example.deezerapp.databinding.GenreAndArtistItemBinding

class GenresAdapter(private val onItemClick :(Int,String)->Unit):RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {
    private val itemList= mutableListOf<GenresUiData>()
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
    private inner class GenreDiffCallback(
        private val oldList: List<GenresUiData>,
        private val newList: List<GenresUiData>,
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
    fun updateGenresAdapterData(newItems: List<GenresUiData>) {
        val diffResult = DiffUtil.calculateDiff(GenreDiffCallback(itemList, newItems))
        itemList.clear()
        itemList.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }

}