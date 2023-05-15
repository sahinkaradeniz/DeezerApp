package com.example.deezerapp.ui.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.common.extension.downloadFromUrl
import com.example.deezerapp.core.DiffCallback
import com.example.deezerapp.databinding.ArtistAlbumItemBinding

class AlbumsAdapter(private val clickItem:(Int,String,String)->Unit):RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {
    private var itemList= listOf<AlbumsUiData>()
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
    fun updateAlbumsAdapterData(newItems: List<AlbumsUiData>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(itemList, newItems))
        itemList=newItems
        diffResult.dispatchUpdatesTo(this)
    }
}