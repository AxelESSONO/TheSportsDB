package com.axel.thesportsdb.model.teams


import com.google.gson.annotations.SerializedName

data class TeamRoot(
    @SerializedName("teams")
    var teams: List<Team>
)