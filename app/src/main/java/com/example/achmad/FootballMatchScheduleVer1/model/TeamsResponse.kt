package com.example.achmad.FootballMatchScheduleVer1.model

import com.google.gson.annotations.SerializedName

data class TeamsResponse(
        @SerializedName("teams")
        var teams: List<Teams>)