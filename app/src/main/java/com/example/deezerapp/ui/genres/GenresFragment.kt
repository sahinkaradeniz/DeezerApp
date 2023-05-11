package com.example.deezerapp.ui.genres

import androidx.fragment.app.viewModels
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.databinding.FragmentGenresBinding

class GenresFragment : BaseFragment<FragmentGenresBinding>(FragmentGenresBinding::inflate) {

    private val viewModel: GenresViewModel by viewModels()

    override fun onCreateFinished() {
        TODO("Not yet implemented")
    }

}