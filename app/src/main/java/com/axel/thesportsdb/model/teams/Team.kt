package com.axel.thesportsdb.model.teams


import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("idAPIfootball")
    var idAPIfootball: String,
    @SerializedName("idLeague")
    var idLeague: String,
    @SerializedName("idLeague2")
    var idLeague2: String,
    @SerializedName("idLeague3")
    var idLeague3: String,
    @SerializedName("idLeague4")
    var idLeague4: String,
    @SerializedName("idLeague5")
    var idLeague5: String,
    @SerializedName("idLeague6")
    var idLeague6: Any,
    @SerializedName("idLeague7")
    var idLeague7: Any,
    @SerializedName("idSoccerXML")
    var idSoccerXML: String,
    @SerializedName("idTeam")
    var idTeam: String,
    @SerializedName("intFormedYear")
    var intFormedYear: String,
    @SerializedName("intLoved")
    var intLoved: String,
    @SerializedName("intStadiumCapacity")
    var intStadiumCapacity: String,
    @SerializedName("strAlternate")
    var strAlternate: String,
    @SerializedName("strCountry")
    var strCountry: String,
    @SerializedName("strDescriptionCN")
    var strDescriptionCN: Any,
    @SerializedName("strDescriptionDE")
    var strDescriptionDE: Any,
    @SerializedName("strDescriptionEN")
    var strDescriptionEN: String,
    @SerializedName("strDescriptionES")
    var strDescriptionES: String,
    @SerializedName("strDescriptionFR")
    var strDescriptionFR: String,
    @SerializedName("strDescriptionHU")
    var strDescriptionHU: Any,
    @SerializedName("strDescriptionIL")
    var strDescriptionIL: Any,
    @SerializedName("strDescriptionIT")
    var strDescriptionIT: String,
    @SerializedName("strDescriptionJP")
    var strDescriptionJP: Any,
    @SerializedName("strDescriptionNL")
    var strDescriptionNL: Any,
    @SerializedName("strDescriptionNO")
    var strDescriptionNO: Any,
    @SerializedName("strDescriptionPL")
    var strDescriptionPL: Any,
    @SerializedName("strDescriptionPT")
    var strDescriptionPT: Any,
    @SerializedName("strDescriptionRU")
    var strDescriptionRU: Any,
    @SerializedName("strDescriptionSE")
    var strDescriptionSE: Any,
    @SerializedName("strDivision")
    var strDivision: Any,
    @SerializedName("strFacebook")
    var strFacebook: String,
    @SerializedName("strGender")
    var strGender: String,
    @SerializedName("strInstagram")
    var strInstagram: String,
    @SerializedName("strKeywords")
    var strKeywords: String,
    @SerializedName("strKitColour1")
    var strKitColour1: String,
    @SerializedName("strKitColour2")
    var strKitColour2: String,
    @SerializedName("strKitColour3")
    var strKitColour3: String,
    @SerializedName("strLeague")
    var strLeague: String,
    @SerializedName("strLeague2")
    var strLeague2: String,
    @SerializedName("strLeague3")
    var strLeague3: String,
    @SerializedName("strLeague4")
    var strLeague4: String,
    @SerializedName("strLeague5")
    var strLeague5: String,
    @SerializedName("strLeague6")
    var strLeague6: String,
    @SerializedName("strLeague7")
    var strLeague7: String,
    @SerializedName("strLocked")
    var strLocked: String,
    @SerializedName("strRSS")
    var strRSS: String,
    @SerializedName("strSport")
    var strSport: String,
    @SerializedName("strStadium")
    var strStadium: String,
    @SerializedName("strStadiumDescription")
    var strStadiumDescription: String,
    @SerializedName("strStadiumLocation")
    var strStadiumLocation: String,
    @SerializedName("strStadiumThumb")
    var strStadiumThumb: String,
    @SerializedName("strTeam")
    var strTeam: String,
    @SerializedName("strTeamBadge")
    var strTeamBadge: String,
    @SerializedName("strTeamBanner")
    var strTeamBanner: String,
    @SerializedName("strTeamFanart1")
    var strTeamFanart1: String,
    @SerializedName("strTeamFanart2")
    var strTeamFanart2: String,
    @SerializedName("strTeamFanart3")
    var strTeamFanart3: String,
    @SerializedName("strTeamFanart4")
    var strTeamFanart4: String,
    @SerializedName("strTeamJersey")
    var strTeamJersey: String,
    @SerializedName("strTeamLogo")
    var strTeamLogo: String,
    @SerializedName("strTeamShort")
    var strTeamShort: String,
    @SerializedName("strTwitter")
    var strTwitter: String,
    @SerializedName("strWebsite")
    var strWebsite: String,
    @SerializedName("strYoutube")
    var strYoutube: String
)