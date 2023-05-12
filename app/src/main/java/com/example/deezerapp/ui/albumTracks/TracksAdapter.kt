package com.example.deezerapp.ui.albumTracks

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.common.extension.downloadFromUrl
import com.example.common.extension.toDurationString
import com.example.deezerapp.R
import com.example.deezerapp.databinding.AlbumTracksItemBinding

class TracksAdapter(
    private val clickItem: (TracksUiData) -> Unit,
    private val clickFavorite: (TracksUiData) -> Unit,
) : RecyclerView.Adapter<TracksAdapter.TracksViewHolder>() {
    private val itemList = mutableListOf<TracksUiData>()

    class TracksViewHolder(val binding: AlbumTracksItemBinding) : ViewHolder(binding.root) {
        fun bind(tracksUiData: TracksUiData) {
            binding.artistName.text = tracksUiData.artist
            binding.durationText.text = tracksUiData.duration.toDurationString()
            binding.titleText.text = tracksUiData.title
            binding.trackImage.downloadFromUrl(tracksUiData.picture)
            if (tracksUiData.isFavorite) {
                binding.favoriteButton.setImageResource(R.drawable.baseline_favorite_24)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksViewHolder {
        val bind =
            AlbumTracksItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TracksViewHolder(bind)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: TracksViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.itemView.rootView.setOnClickListener {
            clickItem.invoke(itemList[position])
        }
        holder.binding.favoriteButton.setOnClickListener {
            clickFavorite.invoke(itemList[position])
            updateFavoriteButtonImage(holder, itemList[position].isFavorite)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newList: List<TracksUiData>) {
        itemList.clear()
        itemList.addAll(newList)
        notifyDataSetChanged()
    }

    private fun updateFavoriteButtonImage(holder: TracksViewHolder, isFavorite: Boolean) {
        val imageResource = if (isFavorite) {
            R.drawable.round_favorite_borde
        } else {
            R.drawable.baseline_favorite_24
        }
        holder.binding.favoriteButton.setImageResource(imageResource)
    }
}