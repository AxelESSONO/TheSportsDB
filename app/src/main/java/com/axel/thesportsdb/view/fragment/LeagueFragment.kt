package com.axel.thesportsdb.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.axel.thesportsdb.R
import com.axel.thesportsdb.databinding.FragmentLeagueBinding
import com.axel.thesportsdb.model.league.League
import com.axel.thesportsdb.view.adapter.LeagueAdapter
import com.axel.thesportsdb.viewmodel.TheSportDbViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class LeagueFragment : Fragment(R.layout.fragment_league) {

    private lateinit var binding: FragmentLeagueBinding

    private val theSportDbViewModel: TheSportDbViewModel by activityViewModels()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var leagueAdapter: LeagueAdapter
    private lateinit var leagues: List<League>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLeagueBinding.inflate(inflater, container, false)
        linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        leagues = mutableListOf()

        leagueAdapter = LeagueAdapter() { league ->
            theSportDbViewModel.sendLeagueName(league.strLeague)
            fragmentManager
                ?.beginTransaction()
                ?.addToBackStack(null)
                ?.remove(LeagueFragment())
                ?.replace(R.id.container, TeamByLeagueFragment())
                ?.commit()
        }
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        binding.recyclerLeague.apply {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            adapter = leagueAdapter
        }
        updateRecyclerView()
    }

    private fun updateRecyclerView() {
        theSportDbViewModel.responseLeague.observe(viewLifecycleOwner) { response ->
            leagues = response.leagues
            leagueAdapter.updateLeagues = leagues
            binding.recyclerLeague.apply {
                layoutManager = linearLayoutManager
                setHasFixedSize(true)
                adapter = leagueAdapter
            }
            theSportDbViewModel.getLeagueName().observe(viewLifecycleOwner) { leagueName ->
                if (leagueName != null) {
                    Log.d("LEAGUE", leagueName)
                    filteredLeagues(leagueName)
                }
            }
        }
    }

    private fun filteredLeagues(leagueName: String?) {
        val leaguesTmp = ArrayList<League>()
        for (league in leagues) {
            if (leagueName != null) {
                if (league.strLeague.uppercase().contains(leagueName.uppercase())) {
                    leaguesTmp.add(league)
                }
            }
        }
        if (leaguesTmp.isEmpty()) {
            Toast.makeText(requireContext(), "No Data Found", Toast.LENGTH_SHORT).show()
        } else {
            leagueAdapter.setFilterLeagues(leaguesTmp)
        }
    }

}