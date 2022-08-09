package com.example.virginmoneychallengearen.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.virginmoneychallengearen.R
import com.example.virginmoneychallengearen.adapters.ViewPagerAdapter
import com.example.virginmoneychallengearen.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main){

    lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        val myViewPager: ViewPager2 = binding.vpMain
        val myTabLayout: TabLayout = binding.tlMain

        val texts = listOf("People", "Room")
        val mAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        myViewPager.adapter = mAdapter

        TabLayoutMediator(myTabLayout,myViewPager){tab,position->
            when(position){
                0 -> tab.text=texts[position]
                1 -> tab.text=texts[position]
            }
        }.attach()
    }
}