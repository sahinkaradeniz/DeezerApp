package com.example.deezerapp.ui.artist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.extension.downloadFromUrl
import com.example.deezerapp.R
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.core.UiState
import com.example.deezerapp.databinding.FragmentArtistBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArtistFragment : BaseFragment<FragmentArtistBinding>(FragmentArtistBinding::inflate) {

    private val viewModel: ArtistViewModel by viewModels()
    private val args :ArtistFragmentArgs by navArgs()
    private val adapter by lazy { AlbumsAdapter(::clickAlbumItem) }

    private fun clickAlbumItem(albumId: Int,albumName:String) {
       val action=ArtistFragmentDirections.actionArtistFragmentToAlbumTracksFragment(albumId,albumName)
        findNavController().navigate(action)
    }

    override fun onCreateFinished() {
        binding.albumsRcv.adapter=adapter
        binding.albumsRcv.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,true)
        observeLiveData()
        val artistId=args.artistId
        viewModel.fetchArtistData(artistId)
    }
    private fun observeLiveData(){
        viewModel.artistUiState.observe(viewLifecycleOwner){
            when(it){
                is UiState.Loading ->{
                    showProgress()
                }
                is UiState.Success->{
                    it.data?.let { artistData ->
                        binding.artistPicture.downloadFromUrl(artistData.picture)
                        binding.artistName.text=artistData.name
                        adapter.updateItems(artistData.albums)
                    }
                    hideProgress()
                }
                is UiState.Error->{
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}