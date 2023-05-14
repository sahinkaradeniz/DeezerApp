package com.example.deezerapp.ui.artist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.common.extension.downloadFromUrl
import com.example.deezerapp.databinding.ArtistAlbumItemBinding
import com.example.deezerapp.ui.albumTracks.TracksUiData

class AlbumsAdapter(private val clickItem:(Int,String,String)->Unit):RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {
    private val itemList= mutableListOf<AlbumsUiData>()
   inner  class AlbumsViewHolder (private val binding:ArtistAlbumItemBinding):ViewHolder(binding.root){
        fun bind(albumsUiData: AlbumsUiData){
            binding.albumImage.downloadFromUrl(albumsUiData.picture)
            binding.albumName.text=albumsUiData.title
            binding.date.text=albumsUiData.date
            binding.root.setOnClickListener {
                clickItem.invoke(albumsUiData.id,albumsUiData.title,albumsUiData.picture)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
       val bind=ArtistAlbumItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AlbumsViewHolder(bind)
    }

    override fun getItemCount(): Int {
      return itemList.size
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
    private inner class AlbumsDiffCallback(
        private val oldList: List<AlbumsUiData>,
        private val newList: List<AlbumsUiData>,
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
    fun updateAlbumsAdapterData(newItems: List<AlbumsUiData>) {
        val diffResult = DiffUtil.calculateDiff(AlbumsDiffCallback(itemList, newItems))
        itemList.clear()
        itemList.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }
}