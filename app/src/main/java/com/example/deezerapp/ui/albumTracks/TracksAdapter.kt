package com.example.deezerapp.ui.albumTracks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
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

    inner class TracksViewHolder(val binding: AlbumTracksItemBinding) : ViewHolder(binding.root) {
        fun bind(tracksUiData: TracksUiData) {
            binding.artistName.text = tracksUiData.artist
            binding.durationText.text = tracksUiData.duration.toDurationString()
            binding.titleText.text = tracksUiData.title
            binding.trackImage.downloadFromUrl(tracksUiData.picture)

            val favoriteResource = if (tracksUiData.isFavorite) {
                R.drawable.baseline_favorite_24
            } else {
                R.drawable.round_favorite_borde
            }
            binding.favoriteButton.setImageResource(favoriteResource)

            binding.favoriteButton.setOnClickListener {
                updateFavoriteStatus(tracksUiData)
                clickFavorite.invoke(tracksUiData)
            }

            binding.root.setOnClickListener {
                clickItem.invoke(tracksUiData)
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
    }

    private inner class TracksDiffCallback(
        private val oldList: List<TracksUiData>,
        private val newList: List<TracksUiData>,
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

    private fun updateFavoriteStatus(track: TracksUiData) {
        val index = itemList.indexOf(track)
        if (index != -1) {
            itemList[index].isFavorite = !itemList[index].isFavorite
            notifyItemChanged(index)
        }
    }

    fun updateTracksAdapterData(newItems: List<TracksUiData>) {
        val diffResult = DiffUtil.calculateDiff(TracksDiffCallback(itemList, newItems))
        itemList.clear()
        itemList.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }
}
