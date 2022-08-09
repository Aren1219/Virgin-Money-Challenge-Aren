package com.example.virginmoneychallengearen.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.virginmoneychallengearen.R
import com.example.virginmoneychallengearen.databinding.FragmentDetailsBinding
import com.example.virginmoneychallengearen.databinding.FragmentPeopleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment: Fragment(R.layout.fragment_details) {

    lateinit var binding: FragmentDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myData_list = requireArguments().get("user_details") as ArrayList<String>
        binding = FragmentDetailsBinding.bind(view)

        binding.tvDtJob.text = myData_list[0]
        binding.tvDtName.text = "${myData_list[1]} ${myData_list[2]}"
        binding.tvDtColor.text = myData_list[5]
        binding.tvDtEmail.text = myData_list[4]
        binding.tvDtId.text = "id: ${myData_list[6]}"

        Glide.with(requireActivity()).load(myData_list[3]).into(binding.ivDtAvatar)
    }
}