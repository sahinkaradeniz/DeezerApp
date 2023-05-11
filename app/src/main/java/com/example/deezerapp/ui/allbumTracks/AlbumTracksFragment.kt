package com.example.deezerapp.ui.allbumTracks

import androidx.fragment.app.viewModels
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.databinding.FragmentAlbumTracksBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumTracksFragment : BaseFragment<FragmentAlbumTracksBinding>(FragmentAlbumTracksBinding::inflate){


    private val viewModel: AlbumTracksViewModel by viewModels()

    override fun onCreateFinished() {

    }

}