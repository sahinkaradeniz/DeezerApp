package com.example.deezerapp.ui.genreArtists

import androidx.fragment.app.viewModels
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.databinding.FragmentGenreArtistsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreArtistsFragment : BaseFragment<FragmentGenreArtistsBinding>(FragmentGenreArtistsBinding::inflate) {

    private val viewModel: GenreArtistsViewModel by viewModels()

    override fun onCreateFinished() {
        
    }

}