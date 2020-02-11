package com.example.fitnessapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.events.calendar.utils.EventsCalendarUtil
import kotlinx.android.synthetic.main.activity_view_training_advice.*
import java.util.*

class VIewTrainingAdviceActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_training_advice)

        val activityOptions = arrayOf("Select Activity", "Running", "Cycling")

        val adapter = ArrayAdapter(
            this, // Context
            android.R.layout.simple_spinner_item,
            activityOptions
        )

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)

        activity_vtadvice_spinner_sport.adapter = adapter

        activity_vtadvice_spinner_sport.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent:AdapterView<*>, view:View, position: Int, id: Long) {
                //text_view.text = "Spinner selected : ${parent.getItemAtPosition(position).toString()}"
                if(position == 0) return
            }

            override fun onNothingSelected(parent: AdapterView<*>){
                // Another interface callback
            }
        }

        val selectedDate = intent.getLongExtra("SELECTED_DATES_LAST", 0)
        val calendar = Calendar.getInstance()
        calendar.setTimeInMillis(selectedDate)
        val lastSelectedDay = EventsCalendarUtil.getDateString(calendar, EventsCalendarUtil.DD_MM_YYYY)




    }
}