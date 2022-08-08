package com.example.virginmoneychallengearen.ui.rooms

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.load.engine.Resource
import com.example.virginmoneychallengearen.R
import com.example.virginmoneychallengearen.adapters.PeopleItemAdapter
import com.example.virginmoneychallengearen.adapters.RoomItemAdapter
import com.example.virginmoneychallengearen.databinding.FragmentRoomsBinding
import com.example.virginmoneychallengearen.util.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomsFragment:Fragment(R.layout.fragment_rooms) {

    lateinit var binding: FragmentRoomsBinding
//    lateinit var viewModel: RoomsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val viewModel: RoomsViewModel by lazy {
//            ViewModelProvider(requireActivity())[RoomsViewModel::class.java]
//        }
        val viewModel: RoomsViewModel by viewModels()
        binding = FragmentRoomsBinding.bind(view)
        binding.rvRooms.layoutManager = LinearLayoutManager(context)

        binding.srRooms.setOnRefreshListener {
            viewModel.getRooms()
        }

        viewModel.getRooms()

        viewModel.rooms.observe(requireActivity()) { state ->
            when(state){
                is UiState.Success -> {
                    binding.srRooms.isRefreshing = false
                    binding.rvRooms.adapter = state.data?.let { RoomItemAdapter(it,requireContext()) }
                }
                is UiState.Loading -> {
                    binding.srRooms.isRefreshing = true
                }
                is UiState.Error -> {
                    binding.srRooms.isRefreshing = false
                }
            }
        }
    }

}