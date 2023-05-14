package com.example.deezerapp.ui.genres

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.extension.gone
import com.example.deezerapp.R
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.core.UiState
import com.example.deezerapp.databinding.FragmentGenresBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenresFragment : BaseFragment<FragmentGenresBinding>(FragmentGenresBinding::inflate) {

    private val viewModel: GenresViewModel by viewModels()
    private val adapter by lazy { GenresAdapter(::onItemClick) }

    override fun onCreateFinished() {
        viewModel.getAllGenresOfMusic()
        binding.genreRcv.adapter = adapter
        binding.genreRcv.layoutManager =
            GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
        observeLiveData()
        binding.genreToolbar.toolbarTitle.text=getString(R.string.genres)
        binding.genreToolbar.toolbarBackButton.gone()
    }

    private fun observeLiveData() {
        viewModel.genresUiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Loading -> {
                    showProgress()
                }
                is UiState.Success -> {
                    hideProgress()
                    it.data?.let { list ->
                        adapter.updateGenresAdapterData(list)
                    }
                }
                is UiState.Error -> {
                    errorMessage(it.message)
                }
            }
        }
    }

    private fun onItemClick(id: Int, name: String) {
        val action = GenresFragmentDirections.actionGenresFragmentToGenreArtistsFragment(id, name)
        findNavController().navigate(action)
    }

}