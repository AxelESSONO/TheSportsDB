package com.axel.thesportsdb.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.axel.thesportsdb.R
import com.axel.thesportsdb.databinding.FragmentTeamByLeagueBinding
import com.axel.thesportsdb.view.adapter.TeamAdapter
import com.axel.thesportsdb.viewmodel.TheSportDbViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class TeamByLeagueFragment : Fragment(R.layout.fragment_team_by_league) {

    private var _binding : FragmentTeamByLeagueBinding? = null
    private val binding get() = _binding!!
    private val theSportDbViewModel : TheSportDbViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTeamByLeagueBinding.inflate(inflater, container, false)

        theSportDbViewModel.getLeagueName().observe(viewLifecycleOwner) { leagueName ->
            CoroutineScope(Dispatchers.Main).launch {
                if (leagueName != null) {
                    theSportDbViewModel.getAllTeamByLeagueName(league = leagueName).observe(viewLifecycleOwner){
                        binding.teamRecycler.apply {
                            setHasFixedSize(true)
                            layoutManager = GridLayoutManager(requireContext(), 2)
                            adapter = TeamAdapter(it.teams){ team ->
                                theSportDbViewModel.sendTeam(team)
                                fragmentManager
                                    ?.beginTransaction()
                                    ?.addToBackStack(null)
                                    ?.remove(TeamByLeagueFragment())
                                    ?.replace(R.id.container, TeamDetailFragment())
                                    ?.commit()
                            }
                        }
                    }
                }
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}