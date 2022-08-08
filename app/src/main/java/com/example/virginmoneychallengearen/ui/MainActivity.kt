package com.example.virginmoneychallengearen.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.virginmoneychallengearen.R
import com.example.virginmoneychallengearen.adapters.ViewPagerAdapter
import com.example.virginmoneychallengearen.api.ApiDetails
import com.example.virginmoneychallengearen.databinding.ActivityMainBinding
import com.example.virginmoneychallengearen.repository.Repository
import com.example.virginmoneychallengearen.repository.RepositoryImp
import com.example.virginmoneychallengearen.ui.people.PeopleFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@AndroidEntryPoint
class MainActivity() : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val myViewPager: ViewPager2 = findViewById(R.id.vpMain)
        val myTabLayout: TabLayout = findViewById(R.id.tlMain)

        val texts = listOf("People", "Room")
        val mAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        myViewPager.adapter = mAdapter

        TabLayoutMediator(myTabLayout,myViewPager){tab,position->
            tab.text=texts[position]
        }.attach()
    }
}