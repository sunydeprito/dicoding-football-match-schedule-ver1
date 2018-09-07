package com.example.achmad.FootballMatchScheduleVer1.activities.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.achmad.FootballMatchScheduleVer1.api.TheSportDBApi
import com.example.achmad.FootballMatchScheduleVer1.api.TheSportDBRest
import com.example.achmad.FootballMatchScheduleVer1.adapter.TeamsAdapter
import com.example.achmad.FootballMatchScheduleVer1.model.MatchEvent
import com.example.achmad.FootballMatchScheduleVer1.model.MatchEventPresenter
import com.example.achmad.FootballMatchScheduleVer1.R
import com.example.achmad.FootballMatchScheduleVer1.R.id.lastMatch
import com.example.achmad.FootballMatchScheduleVer1.R.id.nextMatch
import com.example.achmad.FootballMatchScheduleVer1.utils.invisible
import com.example.achmad.FootballMatchScheduleVer1.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger

class MainActivity : AppCompatActivity(), AnkoLogger, MainView.View {

    lateinit var mPresenter : MainPresenter

    private var matchLists : MutableList<MatchEvent> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = TheSportDBApi.getClient().create(TheSportDBRest::class.java)
        val request = MatchEventPresenter(service)
        mPresenter = MainPresenter(this, request)
        mPresenter.getFootballMatchData()

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
              lastMatch -> {
                  mPresenter.getFootballMatchData()
                }
               nextMatch -> {

                   mPresenter.getFootballUpcomingData()
                }

            }
            true
        }
        bottom_navigation.selectedItemId = lastMatch

    }

    override fun hideLoading() {
        mainProgressBar.invisible()
    }

    override fun showLoading() {
        mainProgressBar.visible()
    }

    override fun displayFootballMatch(matchList: List<MatchEvent>) {
        matchLists.clear()
        matchLists.addAll(matchList)
        val layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rvFootball.layoutManager = layoutManager
        rvFootball.adapter = TeamsAdapter(matchList, applicationContext)
    }


}
