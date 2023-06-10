package com.axel.thesportsdb.model.teams


import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @SerializedName("teams")
    var teams: List<Team>
)