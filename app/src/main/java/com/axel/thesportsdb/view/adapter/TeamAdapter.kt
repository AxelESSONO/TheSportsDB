package com.axel.thesportsdb.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.axel.thesportsdb.databinding.TeamItemBinding
import com.axel.thesportsdb.model.teams.Team

class TeamAdapter(
    private var teams : List<Team>,
    private val listener : (Team) -> Unit) : RecyclerView.Adapter<TeamAdapter.TeamHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        return TeamHolder(
            TeamItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.bindTeam(teams[position], listener)
    }

    override fun getItemCount(): Int = teams.size

    class TeamHolder(private val binding: TeamItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindTeam(team: Team, listener: (Team) -> Unit) = with(itemView){
            binding.team = team
            itemView.setOnClickListener {
                listener(team)
            }
        }
    }
}