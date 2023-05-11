package com.example.deezerapp.ui.artist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.common.extension.downloadFromUrl
import com.example.deezerapp.databinding.ArtistAlbumItemBinding

class AlbumsAdapter(private val clickItem:(Int,String)->Unit):RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {
    private val itemList= mutableListOf<AlbumsUiData>()
    class AlbumsViewHolder (private val binding:ArtistAlbumItemBinding):ViewHolder(binding.root){
        fun bind(albumsUiData: AlbumsUiData){
            binding.albumImage.downloadFromUrl(albumsUiData.picture)
            binding.albumName.text=albumsUiData.title
            binding.date.text=albumsUiData.date
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
        holder.itemView.setOnClickListener {
            clickItem.invoke(itemList[position].id,itemList[position].title)
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems:List<AlbumsUiData>){
        itemList.clear()
        itemList.addAll(newItems)
        notifyDataSetChanged()
    }
}