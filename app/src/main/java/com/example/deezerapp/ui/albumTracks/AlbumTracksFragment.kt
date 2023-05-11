package com.example.deezerapp.ui.albumTracks

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.databinding.FragmentAlbumTracksBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumTracksFragment : BaseFragment<FragmentAlbumTracksBinding>(FragmentAlbumTracksBinding::inflate){

    private val viewModel: AlbumTracksViewModel by viewModels()
    private val args:AlbumTracksFragmentArgs by navArgs()
    override fun onCreateFinished() {
        getArgs()
    }
    private fun getArgs(){
        val albumId=args.albumId
        val albumName=args.albumName
        binding.albumName.text=albumName
    }

}