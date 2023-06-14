package com.axel.thesportsdb.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axel.thesportsdb.model.league.LeaguesResponse
import com.axel.thesportsdb.model.teams.Team
import com.axel.thesportsdb.model.teams.TeamResponse
import com.axel.thesportsdb.repository.TheSportDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class  TheSportDbViewModel
@Inject constructor(private val theSportDbRepository: TheSportDbRepository): ViewModel()
{
    private val _responseLeague = MutableLiveData<LeaguesResponse>()
    val responseLeague : LiveData<LeaguesResponse>
        get() = _responseLeague

    private val _responseTeam = MutableLiveData<TeamResponse>()
    val responseTeam : LiveData<TeamResponse>
        get() = _responseTeam

    private var leagueNameMutableLiveData : MutableLiveData<String?> = MutableLiveData()
    private var teamData : MutableLiveData<Team?> = MutableLiveData()

    init {
        getLeague()
    }

    private fun getLeague() = viewModelScope.launch {
        theSportDbRepository.getLeague().let {response ->
            if (response.isSuccessful) {
                _responseLeague.postValue(response.body())
            }else{
                Log.d("Response Error", "${response.code()}")
            }
        }
    }

    fun sendLeagueName(leagueName : String?) {
        leagueNameMutableLiveData.postValue(leagueName)
    }
    fun getLeagueName() : MutableLiveData<String?> = leagueNameMutableLiveData

    fun sendTeam(team : Team){
        teamData.postValue(team)
    }

    fun getTeam() : MutableLiveData<Team?> = teamData

    suspend fun getAllTeamByLeagueName(league: String) : LiveData<TeamResponse>{
        return theSportDbRepository.getAllTeamsByLeague(league = league)
    }

}