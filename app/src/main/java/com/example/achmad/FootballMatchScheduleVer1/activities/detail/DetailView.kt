package com.example.achmad.FootballMatchScheduleVer1.activities.detail

import com.example.achmad.FootballMatchScheduleVer1.model.Teams

interface DetailView {

    interface View{
        fun displayTeamBadgeHome(team: Teams)
        fun displayTeamBadgeAway(team: Teams)
    }

    interface Presenter{
        fun getTeamsBadgeAway(id:String)
        fun getTeamsBadgeHome(id:String)
    }
}