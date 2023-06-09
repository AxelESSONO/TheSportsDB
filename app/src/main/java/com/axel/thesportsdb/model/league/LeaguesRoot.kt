package com.axel.thesportsdb.model.league


import com.axel.thesportsdb.model.league.League
import com.google.gson.annotations.SerializedName

data class LeaguesRoot(
    @SerializedName("leagues")
    var leagues: List<League>
)