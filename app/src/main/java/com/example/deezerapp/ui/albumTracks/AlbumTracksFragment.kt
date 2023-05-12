package com.example.deezerapp.ui.albumTracks

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.core.UiState
import com.example.deezerapp.databinding.FragmentAlbumTracksBinding
import com.example.domain.entity.FavoritesEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumTracksFragment :
    BaseFragment<FragmentAlbumTracksBinding>(FragmentAlbumTracksBinding::inflate) {

    private val viewModel: AlbumTracksViewModel by viewModels()
    private val args: AlbumTracksFragmentArgs by navArgs()
    private val adapter by lazy { TracksAdapter(::clickItem, ::clickFavoriteButton) }

    override fun onCreateFinished() {
        getArgs()
        observeLiveData()
        binding.tracksRcv.adapter = adapter
        binding.tracksRcv.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun getArgs() {
        val albumId = args.albumId
        val albumName = args.albumName
        viewModel.getAlbumTracksWithAlbumId(albumId)
        binding.albumName.text = albumName
    }

    private fun observeLiveData() {
        viewModel.tracksUiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Error -> {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                }
                is UiState.Success -> {
                    val albumPicture = args.albumPicture
                    it.data?.let { list ->
                        list.map { track ->
                            track.picture = albumPicture
                        }
                        adapter.updateData(list)
                    }
                    hideProgress()
                }
                is UiState.Loading -> {
                    showProgress()
                }
            }
        }
        viewModel.favoriteState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Loading -> {}
                is UiState.Error -> {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                }
                is UiState.Success -> {
                    Toast.makeText(requireContext(), it.data, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun clickFavoriteButton(tracksUiData: TracksUiData) {
        viewModel.changeIsFavorite(tracksUiData)
    }

    private fun clickItem(trackId: Int) {
        Toast.makeText(requireContext(), "click $trackId", Toast.LENGTH_SHORT).show()
    }

}