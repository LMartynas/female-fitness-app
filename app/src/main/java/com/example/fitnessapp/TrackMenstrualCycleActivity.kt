package com.example.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.core.view.children
import com.events.calendar.utils.EventsCalendarUtil
import com.events.calendar.views.EventsCalendar
import com.events.calendar.utils.EventsCalendarUtil.getDateString
import com.jakewharton.threetenabp.AndroidThreeTen
import kotlinx.android.synthetic.main.activity_track_menstrual_cycle.*
import kotlinx.android.synthetic.main.calendar_day_legend.*
import org.threeten.bp.LocalDate
import org.threeten.bp.YearMonth
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.TextStyle
import java.util.*

class TrackMenstrualCycleActivity: AppCompatActivity() {

    private val selectedDates = mutableSetOf<LocalDate>()
    private val today = LocalDate.now()
    private val monthTitleFormatter = DateTimeFormatter.ofPattern("MMMM")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidThreeTen.init(this)

        setContentView(R.layout.activity_track_menstrual_cycle)

        val daysOfWeek = daysOfWeekFromLocale()
        legendLayout.children.forEachIndexed { index, view ->
            (view as TextView).apply {
                text = daysOfWeek[index].getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase(Locale.ENGLISH)
                setTextColorRes(R.color.example_1_white_light)
            }
        }

        val currentMonth = YearMonth.now()
        val startMonth = currentMonth.minusMonths(3)
        val endMonth = currentMonth.plusMonths(1)
//        exOneCalendar.setup(startMonth, endMonth, daysOfWeek.first())
//        exOneCalendar.scrollToMonth(currentMonth)


    }
}