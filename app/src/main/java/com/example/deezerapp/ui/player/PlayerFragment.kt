package com.example.deezerapp.ui.player

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.deezerapp.R
import com.example.deezerapp.core.BaseFragment
import com.example.deezerapp.databinding.FragmentPlayerBinding

class PlayerFragment : BaseFragment<FragmentPlayerBinding>(FragmentPlayerBinding::inflate) {

    private val viewModel: PlayerViewModel by viewModels()

    override fun onCreateFinished() {

    }



}