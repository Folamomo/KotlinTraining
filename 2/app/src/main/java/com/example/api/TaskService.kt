package com.example.api

import com.example.tasksmanager.model.Task
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface TaskService {

    @POST("tasks.json")
    fun addTask(@Body task: Task): Call<Void>

}