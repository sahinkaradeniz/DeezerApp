package com.example.deezerapp.ui.genreArtists

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.core.UiState
import com.example.deezerapp.databinding.FragmentGenreArtistsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreArtistsFragment :
    BaseFragment<FragmentGenreArtistsBinding>(FragmentGenreArtistsBinding::inflate) {

    private val viewModel: GenreArtistsViewModel by viewModels()
    private val adapter by lazy { GenreArtistsAdapter(::clickRcvItem) }
    private val args: GenreArtistsFragmentArgs by navArgs()
    private fun clickRcvItem(artistId: Int) {
        Toast.makeText(requireContext(), artistId, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateFinished() {
        getArgs()
        binding.artistsRcv.adapter = adapter
        binding.artistsRcv.layoutManager =
            GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
        observeLiveData()
    }


    override fun initListener() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun observeLiveData() {
        viewModel.genreArtistsUiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Loading -> {
                    showProgress()
                }
                is UiState.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is UiState.Success -> {
                    hideProgress()
                    it.data?.let { list ->
                        adapter.updateData(list)
                    }
                }
            }
        }
    }
    private fun getArgs(){
        val genreId = args.genresId
        val genreName=args.genreName
        binding.genreName.text=genreName
        viewModel.getGenreArtistsWithGenreId(genreId)
    }

}