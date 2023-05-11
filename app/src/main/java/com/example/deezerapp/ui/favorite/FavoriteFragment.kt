package com.example.deezerapp.ui.favorite

import androidx.fragment.app.viewModels
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.databinding.FragmentFavoriteBinding

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate){

    private val viewModel: FavoriteViewModel by viewModels()
    override fun onCreateFinished() {
        TODO("Not yet implemented")
    }
}