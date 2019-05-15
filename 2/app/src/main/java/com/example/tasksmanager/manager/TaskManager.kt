package com.example.tasksmanager.manager

import android.content.Context
import android.widget.Toast
import com.example.api.TaskApi
import com.example.tasksmanager.model.Task
import com.example.tasksmanager.util.StorageOperations
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskManager{

    var tasks = mutableListOf<Task>()
    private set

    val taskApi = TaskApi()

    fun loadFromStorage(context: Context) {
        val json = StorageOperations.loadString(context, StorageOperations.TASKS_KEY)
        json?.let {
            tasks.clear()
            tasks.addAll(Task.arrayFromJson(json))
        }
    }
    fun addNewTask(context: Context, task: Task){
        tasks.add(task)
        StorageOperations.save(context, StorageOperations.TASKS_KEY, Task.arrayToJson(tasks))

        taskApi.addTask(task).enqueue(object : Callback<Void>{
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(context, "Nie powiodło się", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful){
                    Toast.makeText(context, "Udało się dodać", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Nie udało: ${response.message()}", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}