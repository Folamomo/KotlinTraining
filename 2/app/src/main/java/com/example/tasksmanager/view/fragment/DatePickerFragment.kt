package com.example.tasksmanager.view.fragment

import android.app.DatePickerDialog
import android.app.Dialog

import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.tasksmanager.view.activity.TaskActivity
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current date as the default date in the picker
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(activity, this, year, month, day)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        val c = Calendar.getInstance().apply {
            set(year, month, day)
        }
        (activity as? TaskActivity)?.dateFromPicker = c

        TimePickerFragment().show(activity?.supportFragmentManager, "timePicker")
    }
}