package com.example.deezerapp.ui.albumTracks

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
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
import com.example.deezerapp.util.manager.MediaPlayerManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AlbumTracksFragment :
    BaseFragment<FragmentAlbumTracksBinding>(FragmentAlbumTracksBinding::inflate) {

    private val viewModel: AlbumTracksViewModel by viewModels()
    private val args: AlbumTracksFragmentArgs by navArgs()
    private val adapter by lazy { TracksAdapter(::onItemClick, ::onFavoriteButtonClick) }

    @Inject
    lateinit var mediaPlayerManager: MediaPlayerManager
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
        binding.tracksToolbar.toolbarTitle.text = albumName
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
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.favoriteUiState.collectLatest { uiState ->
                    when (uiState) {
                        is UiState.Loading -> {}
                        is UiState.Error -> {
                            errorMessage(uiState.message)
                        }
                        is UiState.Success -> {
                            uiState.data?.let { it1 -> requireContext().toastMessage(it1) }
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                mediaPlayerManager.isPlaying.collectLatest { isPlaying ->
                    val playPauseButtonImage = if (isPlaying) {
                        R.drawable.round_stop_24
                    } else {
                        R.drawable.round_play_arrow_24
                    }
                    binding.playPauseButton2.setImageResource(playPauseButtonImage)
                }
            }
        }
    }

    override fun initListener() {
        binding.playPauseButton2.setOnClickListener {
            mediaPlayerManager.togglePlayback()
        }
        binding.tracksToolbar.toolbarBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun onFavoriteButtonClick(tracksUiData: TracksUiData) {
        viewModel.changeIsFavorite(tracksUiData)
    }

    private fun onItemClick(tracksUiData: TracksUiData) {
        if (requireContext().isNetworkAvailable()) {
            mediaPlayerManager.startPlayback(tracksUiData.preview)
            binding.playerView.visible()
            binding.playArtistName.text = tracksUiData.artist
            binding.playMusicName.text = tracksUiData.title
        } else {
            requireContext().navigateToInternetSettingsWithConfirmation()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayerManager.release()
    }

}