package com.example.api

import com.example.tasksmanager.model.Task
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body

const val API_URL = "https://tasksmanager-7d347.firebaseio.com/"

class TaskApi {

    private val api: TaskService

    init {
        val gson = GsonBuilder().create()
        val retrofit = Retrofit
            .Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        api = retrofit.create(TaskService::class.java)
    }

    fun addTask(@Body task: Task): Call<Void> = api.addTask(task)
}