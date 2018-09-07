package com.example.achmad.FootballMatchScheduleVer1.model

import com.example.achmad.FootballMatchScheduleVer1.api.TheSportDBRest
import io.reactivex.Flowable

class MatchEventPresenter(private val theSportDBRest: TheSportDBRest) : MatchEventView {

    override fun getUpcomingMatch(id: String): Flowable<MatchEventResponse> = theSportDBRest.getUpcomingMatch(id)

    override fun getFootballMatch(id: String): Flowable<MatchEventResponse> = theSportDBRest.getLastmatch(id)

    override fun getTeams(id: String): Flowable<TeamsResponse> = theSportDBRest.getTeam(id)
}