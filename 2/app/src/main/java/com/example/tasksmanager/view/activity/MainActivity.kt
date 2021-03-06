package com.example.tasksmanager.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.tasksmanager.R

class MainActivity : AppCompatActivity() {

    private var counter = 0

    var tag = "TaskApp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view)
        val buttonClicked = findViewById<Button>(R.id.clicked_button)

        textView.text = getString(R.string.default_text)


        buttonClicked.setOnClickListener {
            textView.text = getString(R.string.clicks) + (++counter)
            showTaskActivity()
            Log.d(tag,counter.toString())
        }
        Log.d(tag, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy")
    }
    fun showTaskActivity() {
        val intent = Intent(this, TaskActivity::class.java)
        intent.putExtra("extra.COUNT", counter)
        startActivity(intent)
    }
}
