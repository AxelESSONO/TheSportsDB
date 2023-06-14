package com.axel.thesportsdb.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.axel.thesportsdb.databinding.LeagueItemBinding
import com.axel.thesportsdb.model.league.League

class LeagueAdapter(
    //private var leagues: List<League>? = null,
    private val listener: (League) -> Unit) : RecyclerView.Adapter<LeagueAdapter.LeagueHolder>() {


    private val diffCallBack = object : DiffUtil.ItemCallback<League>(){
        override fun areItemsTheSame(oldItem: League, newItem: League): Boolean {
            return oldItem.idLeague == newItem.idLeague
        }
        override fun areContentsTheSame(oldItem: League, newItem: League): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var leagues : List<League>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    var updateLeagues : List<League>
        get() = leagues
        set(value) {
            this.leagues = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueAdapter.LeagueHolder =
        LeagueHolder(
            LeagueItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: LeagueAdapter.LeagueHolder, position: Int) {
        holder.bindLeague(leagues[position], listener)
    }

    override fun getItemCount(): Int = leagues.size

    @SuppressLint("NotifyDataSetChanged")
    fun setFilterLeagues(newLeagues: List<League>){
        leagues = newLeagues
        notifyDataSetChanged()
    }

    class LeagueHolder(private val binding: LeagueItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindLeague(league: League, listener: (League) -> Unit) = with(itemView) {
            binding.league = league
            itemView.setOnClickListener {
                listener(league)
            }
        }
    }
}