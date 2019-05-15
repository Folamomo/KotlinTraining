package com.example.tasksmanager.model

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.util.*

data class Task(var name: String, var comment: String, var date: Date?, var important: Boolean) :Serializable{

    companion object {
        fun arrayToJson(list: List<Task>) = Gson().toJson(list)

        fun arrayFromJson(json: String) = Gson().fromJson<List<Task>>(json, object : TypeToken<List<Task>> () {}.type)
    }
}