package com.axel.thesportsdb.model.league


import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("idLeague")
    var idLeague: String,
    @SerializedName("strLeague")
    var strLeague: String,
    @SerializedName("strLeagueAlternate")
    var strLeagueAlternate: String,
    @SerializedName("strSport")
    var strSport: String
)