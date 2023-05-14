package com.example.deezerapp.ui.albumTracks

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.extension.isNetworkAvailable
import com.example.common.extension.navigateToInternetSettingsWithConfirmation
import com.example.common.extension.toastMessage
import com.example.common.extension.visible
import com.example.deezerapp.R
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.core.UiState
import com.example.deezerapp.databinding.FragmentAlbumTracksBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumTracksFragment :
    BaseFragment<FragmentAlbumTracksBinding>(FragmentAlbumTracksBinding::inflate) {

    private val viewModel: AlbumTracksViewModel by viewModels()
    private val args: AlbumTracksFragmentArgs by navArgs()
    private val adapter by lazy { TracksAdapter(::onItemClick, ::onFavoriteButtonClick) }

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
                    errorMessage(it.message)
                }
                is UiState.Success -> {
                    val albumPicture = args.albumPicture
                    it.data?.let { list ->
                        list.map { track ->
                            track.picture = albumPicture
                        }
                        adapter.updateTracksAdapterData(list)
                    }
                    hideProgress()
                }
                is UiState.Loading -> {
                    showProgress()
                }
            }
        }
        viewModel.favoriteState.observe(viewLifecycleOwner) { event ->
            event.getContentIfNotHandled()?.let {
                when (it) {
                    is UiState.Loading -> {}
                    is UiState.Error -> {
                        errorMessage(it.message)
                    }
                    is UiState.Success -> {
                        it.data?.let { it1 -> requireContext().toastMessage(it1) }
                    }
                }
            }
        }
        viewModel.isPlaying.observe(viewLifecycleOwner) { isPlaying ->
            val playPauseButtonImage = if (isPlaying) {
                binding.playerView.visible()
                R.drawable.round_stop_24
            } else {
                R.drawable.round_play_arrow_24
            }
            binding.playPauseButton2.setImageResource(playPauseButtonImage)
        }
    }

    override fun initListener() {
        binding.playPauseButton2.setOnClickListener {
            viewModel.togglePlayback()
        }
    }

    private fun onFavoriteButtonClick(tracksUiData: TracksUiData) {
        viewModel.changeIsFavorite(tracksUiData)
    }

    private fun onItemClick(tracksUiData: TracksUiData) {
        if (requireContext().isNetworkAvailable()) {
            playMusic(tracksUiData)
        } else {
            requireContext().navigateToInternetSettingsWithConfirmation()
        }
    }

    private fun playMusic(tracksUiData: TracksUiData) {
        binding.playArtistName.text = tracksUiData.artist
        binding.playMusicName.text = tracksUiData.title
        viewModel.startPlayback(
            tracksUiData.preview
        )
    }

}