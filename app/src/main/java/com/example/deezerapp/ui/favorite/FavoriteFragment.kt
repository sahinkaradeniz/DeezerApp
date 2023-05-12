package com.example.deezerapp.ui.favorite

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.core.UiState
import com.example.deezerapp.databinding.FragmentFavoriteBinding
import com.example.domain.entity.FavoritesEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {
    private val adapter by lazy { FavoritesAdapter(::onClickFavoritesButton) }
    private val viewModel: FavoriteViewModel by viewModels()
    private fun onClickFavoritesButton(favoritesEntity: FavoritesEntity) {
        viewModel.deleteTrackFavorites(favoritesEntity)
    }

    override fun onCreateFinished() {
        binding.favoritesRcv.adapter=adapter
        binding.favoritesRcv.layoutManager=LinearLayoutManager(requireContext())
        observeLiveData()
        viewModel.getAllFavoriteTracks()
    }

    private fun observeLiveData() {
        viewModel.favoriteUiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Success -> {
                    hideProgress()
                    adapter.updateItems(it.data ?: emptyList())
                }
                is UiState.Error -> {
                    Toast.makeText(requireContext(), "Error $it", Toast.LENGTH_SHORT).show()
                }
                is UiState.Loading -> {
                    showProgress()
                }
            }
        }
        viewModel.deleteFavoriteUiState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Success -> {
                }
                is UiState.Error -> {
                    Toast.makeText(requireContext(), "Error $it", Toast.LENGTH_SHORT).show()
                }
                is UiState.Loading -> {
                    Toast.makeText(
                        requireContext(),
                        "Deleting Track...",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
        }
    }
}