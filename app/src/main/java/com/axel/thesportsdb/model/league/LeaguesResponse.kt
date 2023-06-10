package com.axel.thesportsdb.model.league


import com.google.gson.annotations.SerializedName

data class LeaguesResponse(
    @SerializedName("leagues")
    var leagues: List<League>
)