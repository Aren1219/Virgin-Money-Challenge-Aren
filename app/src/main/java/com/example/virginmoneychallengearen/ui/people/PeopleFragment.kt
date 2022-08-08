package com.example.virginmoneychallengearen.ui.people

import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virginmoneychallengearen.R
import com.example.virginmoneychallengearen.adapters.PeopleItemAdapter
import com.example.virginmoneychallengearen.adapters.RoomItemAdapter
import com.example.virginmoneychallengearen.databinding.FragmentPeopleBinding
import com.example.virginmoneychallengearen.util.UiState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PeopleFragment: Fragment(R.layout.fragment_people) {

    private lateinit var binding: FragmentPeopleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel by lazy {
            ViewModelProvider(requireActivity())[PeopleViewModel::class.java]
        }

//        val viewModel = hiltViewModel<PeopleViewModel>()

        binding = FragmentPeopleBinding.bind(view)

        binding.rvPeople.apply {
//            setBackgroundResource(R.color.bgClassicMusic)
            background = AppCompatResources.getDrawable(context, R.color.teal_200)
            layoutManager = LinearLayoutManager(context)
        }

        binding.srPeople.setOnRefreshListener {
            viewModel.getPeople()
        }
        viewModel.getPeople()

        viewModel.details.observe(requireActivity()) { state ->
            when(state) {
                is UiState.Loading -> {
                    binding.srPeople.isRefreshing = true
                }
                is UiState.Success -> {
                    binding.rvPeople.adapter = state.data?.let { PeopleItemAdapter(it,requireContext()) }
//                    state.data?.let { PeopleItemAdapter(it,requireContext()) }
                    binding.srPeople.isRefreshing = false
                }
                is UiState.Error -> {
                    binding.srPeople.isRefreshing = false
                }
            }
        }
    }
}