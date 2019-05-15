package com.example.tasksmanager.util

import android.content.Context

object StorageOperations {
    const val SHARED_PREF_NAME = "SHARED_PREF_TASKS"
    const val TASKS_KEY = "TASKS_KEY"

    fun save(context: Context, key: String, value: String) {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun loadString(context: Context, key: String): String? {
        val sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, null)
    }
}
