package com.axel.thesportsdb.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import com.axel.thesportsdb.R
import com.axel.thesportsdb.databinding.ActivityHomeBinding
import com.axel.thesportsdb.view.fragment.LeagueFragment
import com.axel.thesportsdb.view.fragment.TeamByLeagueFragment
import com.axel.thesportsdb.viewmodel.TheSportDbViewModel
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.commonEmptyResponse

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityHomeBinding
    private val theSportDbViewModel : TheSportDbViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, LeagueFragment())
            .commitNow()

        binding.leagueSearchView.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        binding.cancelText.visibility = View.VISIBLE
        return true
    }

    override fun onQueryTextChange(newLeagueName: String?): Boolean {
        binding.cancelText.visibility = View.VISIBLE
        theSportDbViewModel.sendLeagueName(newLeagueName)

        return true
    }
}