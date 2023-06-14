package com.axel.thesportsdb.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.axel.thesportsdb.R
import com.axel.thesportsdb.databinding.FragmentTeamDetailBinding
import com.axel.thesportsdb.viewmodel.TheSportDbViewModel

class TeamDetailFragment : Fragment(R.layout.fragment_team_detail) {

    private lateinit var binding : FragmentTeamDetailBinding
    private val theSportDbViewModel : TheSportDbViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamDetailBinding.inflate(inflater, container, false)

        theSportDbViewModel.getTeam().observe(viewLifecycleOwner){ team ->
            binding.team = team
        }
        return binding.root
    }
}