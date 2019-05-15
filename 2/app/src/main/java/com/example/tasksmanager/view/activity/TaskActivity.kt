package com.example.tasksmanager.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tasksmanager.R
import com.example.tasksmanager.model.Task
import com.example.tasksmanager.view.fragment.DatePickerFragment
import com.example.tasksmanager.view.fragment.TimePickerFragment
import kotlinx.android.synthetic.main.activity_task.*
import java.util.*

class TaskActivity : AppCompatActivity() {

    var dateFromPicker: Calendar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        intent?.extras?.getInt("extra.COUNT")?.let {
            Toast.makeText(this, "W mainie kliknąłeś $it", Toast.LENGTH_SHORT).show()
        }
    }

    fun showTimePickerDialog(v: View) {
        TimePickerFragment().show(supportFragmentManager, "timePicker")
    }

    fun showDatePickerDialog(v: View) {
        val newFragment = DatePickerFragment()
        newFragment.show(supportFragmentManager, "datePicker")
    }

    fun updateDateFromPicker() {
        task_date_tv.text = dateFromPicker?.time.toString()
    }

    fun saveTask(v: View){
        val task = getDataTask()
        showHomeActivity(task)
        finish()
    }

    private fun getDataTask(): Task {
        return Task (
            task_name_ed.text.toString(),
            task_comment_ed.text.toString(),
            dateFromPicker?.time,
            task_important_cb.isChecked
        )
    }

    private fun showHomeActivity(task: Task){
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra(HomeActivity.EXTRA_SAVE_TASK, task)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
        startActivity(intent)
    }
}
