package com.example.achmad.FootballMatchScheduleVer1.activities.main

import com.example.achmad.FootballMatchScheduleVer1.model.MatchEvent

interface MainView {

    interface View{
        fun hideLoading()
        fun showLoading()
        fun displayFootballMatch(matchList:List<MatchEvent>)
    }

    interface Presenter{
        fun getFootballMatchData()

        fun getFootballUpcomingData()
    }

}