package com.example.deezerapp.ui.favorite

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.extension.gone
import com.example.common.extension.toastMessage
import com.example.deezerapp.R
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.core.UiState
import com.example.deezerapp.databinding.FragmentFavoriteBinding
import com.example.domain.entity.FavoritesEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {
    private val adapter by lazy { FavoritesAdapter(::onClickFavoritesButton) }
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateFinished() {
        binding.favoritesRcv.adapter = adapter
        binding.favoritesRcv.layoutManager = LinearLayoutManager(requireContext())
        observeLiveData()
        viewModel.getAllFavoriteTracks()
        binding.favoritesToolbar.toolbarTitle.text = getString(R.string.favorite)
        binding.favoritesToolbar.toolbarBackButton.gone()
    }

    private fun observeLiveData() {
        viewModel.favoriteUiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Success -> {
                    hideProgress()
                    adapter.updateFavoritesAdapterData(it.data ?: emptyList())
                }
                is UiState.Error -> {
                    errorMessage(it.message)
                }
                is UiState.Loading -> {
                    showProgress()
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.deleteFavoriteUiState.collectLatest {
                    when (it) {
                        is UiState.Success -> {
                            requireContext().toastMessage("Removed favorite")
                        }
                        is UiState.Error -> {
                            errorMessage(it.message)
                        }
                        is UiState.Loading -> {
                        }
                    }
                }
            }
        }
    }

    private fun onClickFavoritesButton(favoriteUiData: FavoriteUiData) {
        viewModel.deleteTrackFavorites(favoriteUiData)
    }
}