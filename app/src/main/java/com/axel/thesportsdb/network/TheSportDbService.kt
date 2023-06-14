package com.axel.thesportsdb.network

import com.axel.thesportsdb.BuildConfig
import com.axel.thesportsdb.model.league.LeaguesResponse
import com.axel.thesportsdb.model.teams.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheSportDbService {

    @GET("{apiKey}/all_leagues.php")
    suspend fun getLeague(@Path("apiKey") apiKey: String = BuildConfig.API_KEY) : Response<LeaguesResponse>

    @GET("{apiKey}/search_all_teams.php")
    suspend fun getSearchAllTeamsByLeagueName(
        @Path("apiKey") apiKey: String = BuildConfig.API_KEY,
        @Query("l") league : String
    ) : Response<TeamResponse>

}