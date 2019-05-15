package com.example.tasksmanager.view.activity

import android.content.AbstractThreadedSyncAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tasksmanager.R
import com.example.tasksmanager.manager.TaskManager
import com.example.tasksmanager.model.Task
import com.example.tasksmanager.view.adapter.TaskAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SAVE_TASK = "extra.SAVE_TASK"
    }

    val taskManager = TaskManager()
//    var tasks = mutableListOf<String>()
    lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setUpListView()

        taskManager.loadFromStorage(this)
    }

    private fun setUpListView() {
        adapter = TaskAdapter(this, taskManager.tasks)
        home_tasks_lv.adapter = adapter
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        intent?.extras?.getSerializable(EXTRA_SAVE_TASK).let {
            Toast.makeText(this, "$it", Toast.LENGTH_SHORT).show()

            taskManager.addNewTask(this, it as Task)
            adapter.notifyDataSetChanged()
        }
    }

    fun showAddTaskActivity(v: View){
        startActivity(Intent(this, TaskActivity::class.java))
    }
}
