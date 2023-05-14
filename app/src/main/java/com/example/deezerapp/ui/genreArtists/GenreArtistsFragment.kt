package com.example.deezerapp.ui.genreArtists

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
    private val adapter by lazy { GenreArtistsAdapter(::onClickItem) }
    private val args: GenreArtistsFragmentArgs by navArgs()

    override fun onCreateFinished() {
        getArgs()
        binding.artistsRcv.adapter = adapter
        binding.artistsRcv.layoutManager =
            GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
        observeLiveData()
    }

    override fun initListener() {
        binding.genreToolbar.toolbarBackButton.setOnClickListener {
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
                    errorMessage(it.message)
                }
                is UiState.Success -> {
                    hideProgress()
                    it.data?.let { list ->
                        adapter.updateFavoritesAdapterData(list)
                    }
                }
            }
        }
    }

    private fun getArgs() {
        val genreId = args.genresId
        val genreName = args.genreName
        binding.genreToolbar.toolbarTitle.text = genreName
        viewModel.getGenreArtistsWithGenreId(genreId)
    }

    private fun onClickItem(artistId: Int) {
        val action =
            GenreArtistsFragmentDirections.actionGenreArtistsFragmentToArtistFragment(artistId)
        findNavController().navigate(action)
    }
}