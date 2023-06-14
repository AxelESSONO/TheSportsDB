package com.axel.thesportsdb.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.axel.thesportsdb.model.league.LeaguesResponse
import com.axel.thesportsdb.model.teams.TeamResponse
import com.axel.thesportsdb.network.TheSportDbService
import javax.inject.Inject


class TheSportDbRepository
@Inject constructor(private val theSportDbService: TheSportDbService)
{
    suspend fun getLeague() = theSportDbService.getLeague()

    suspend fun getAllTeamsByLeague(league : String) : LiveData<TeamResponse>{

        val teamsLiveData : MutableLiveData<TeamResponse> = MutableLiveData()
        theSportDbService.getSearchAllTeamsByLeagueName(league = league).let { response ->
            if (response.isSuccessful){
                teamsLiveData.postValue(response.body())
            }else{
                teamsLiveData.postValue(null)
            }
        }
        return teamsLiveData
    }
}