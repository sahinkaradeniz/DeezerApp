package com.example.deezerapp.ui.genres

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.core.UiState
import com.example.deezerapp.databinding.FragmentGenresBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenresFragment : BaseFragment<FragmentGenresBinding>(FragmentGenresBinding::inflate) {

    private val viewModel: GenresViewModel by viewModels()
    private val adapter by lazy { GenresAdapter(::adapterRowClick) }

    private fun adapterRowClick(id: Int) {
        Toast.makeText(requireContext(), "click $id", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateFinished() {
        viewModel.getAllGenresOfMusic()
        binding.genreRcv.adapter = adapter
        binding.genreRcv.layoutManager =
            GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
        observeLiveData()
    }
    private fun observeLiveData(){
        viewModel.genresList.observe(viewLifecycleOwner){ it ->
            when(it){
                is UiState.Loading ->{
                    showProgress()
                }
                is UiState.Success ->{
                    hideProgress()
                    it.data?.let { list ->
                        adapter.updateData(list)
                    }
                }
                is UiState.Error ->{
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}