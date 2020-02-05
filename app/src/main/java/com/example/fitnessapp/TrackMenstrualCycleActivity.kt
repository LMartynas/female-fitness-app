package com.example.fitnessapp

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.events.calendar.utils.EventsCalendarUtil
import com.events.calendar.views.EventsCalendar
import com.events.calendar.utils.EventsCalendarUtil.getDateString
//import com.events.calendarsample.FontsManager
import kotlinx.android.synthetic.main.activity_track_menstrual_cycle.*
import java.util.*

class TrackMenstrualCycleActivity: AppCompatActivity(), EventsCalendar.Callback {

    override fun onDayLongPressed(selectedDate: Calendar?) {
        Log.d("LONG CLICKED", EventsCalendarUtil.getDateString(selectedDate, EventsCalendarUtil.DD_MM_YYYY))
    }

    override fun onMonthChanged(monthStartDate: Calendar?) {
        Log.d("MON", "CHANGED")
    }

    override fun onDaySelected(selectedDate: Calendar?) {
        Log.d("CLICKED", EventsCalendarUtil.getDateString(selectedDate, EventsCalendarUtil.DD_MM_YYYY))
//        selected.text = getDateString(selectedDate?.timeInMillis)
    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.activity_track_menstrual_cycle, container, false)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_track_menstrual_cycle)

//        selected.text = getDateString(eventsCalendar.getCurrentSelectedDate()?.timeInMillis)

        val today = Calendar.getInstance()
        val start = Calendar.getInstance()
        start.add(Calendar.MONTH, -3)

        val end = Calendar.getInstance()
        end.add(Calendar.YEAR, 2)

        eventsCalendar.setSelectionMode(eventsCalendar.MULTIPLE_SELECTION)
            .setToday(today)
            .setMonthRange(start, end)
            .setWeekStartDay(Calendar.SUNDAY, false)
            .setCurrentSelectedDate(today)
            .setIsBoldTextOnSelectionEnabled(true)
//            .setDatesTypeface(FontsManager.getTypeface(FontsManager.OPENSANS_REGULAR, this))
//            .setMonthTitleTypeface(FontsManager.getTypeface(FontsManager.OPENSANS_SEMIBOLD, this))
//            .setWeekHeaderTypeface(FontsManager.getTypeface(FontsManager.OPENSANS_SEMIBOLD, this))
            .setCallback(this)
            .build()

        val c = Calendar.getInstance()
        c.add(Calendar.DAY_OF_MONTH, 2)
        eventsCalendar.addEvent(c)
        c.add(Calendar.DAY_OF_MONTH, 3)
        eventsCalendar.addEvent(c)
        c.add(Calendar.DAY_OF_MONTH, 4)
        eventsCalendar.addEvent(c)
        c.add(Calendar.DAY_OF_MONTH, 7)
        eventsCalendar.addEvent(c)
        c.add(Calendar.MONTH, 1)
        c[Calendar.DAY_OF_MONTH] = 1
        eventsCalendar.addEvent(c)

//        selected.setOnClickListener {
//            val dates = eventsCalendar.getDatesFromSelectedRange()
//            Log.e("SELECTED SIZE", dates.size.toString())
//        }
//
//        selected.typeface = FontsManager.getTypeface(FontsManager.OPENSANS_SEMIBOLD, this)


        val dc = Calendar.getInstance()
        dc.add(Calendar.DAY_OF_MONTH, 2)
    }

    private fun getDateString(time: Long?): String {
        if (time != null) {
            val cal = Calendar.getInstance()
            cal.timeInMillis = time
            val month = when (cal[Calendar.MONTH]) {
                Calendar.JANUARY -> "January"
                Calendar.FEBRUARY -> "February"
                Calendar.MARCH -> "March"
                Calendar.APRIL -> "April"
                Calendar.MAY -> "May"
                Calendar.JUNE -> "June"
                Calendar.JULY -> "July"
                Calendar.AUGUST -> "August"
                Calendar.SEPTEMBER -> "September"
                Calendar.OCTOBER -> "October"
                Calendar.NOVEMBER -> "November"
                Calendar.DECEMBER -> "December"
                else -> ""
            }
            return "$month ${cal[Calendar.DAY_OF_MONTH]}, ${cal[Calendar.YEAR]}"
        } else return ""
    }
}