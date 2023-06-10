package com.axel.thesportsdb.repository

import com.axel.thesportsdb.network.TheSportDbService
import javax.inject.Inject


class TheSportDbRepository
@Inject constructor(private val theSportDbService: TheSportDbService)
{
    suspend fun getLeague() = theSportDbService.getLeague()

    suspend fun getSearchAllTeamsByLeagueName(league : String) = theSportDbService
        .getSearchAllTeamsByLeagueName(league)
}