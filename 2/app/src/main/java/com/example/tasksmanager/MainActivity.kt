package com.example.tasksmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view)
        val buttonClicked = findViewById<Button>(R.id.clicked_button)

        textView.text = getString(R.string.default_text)


        buttonClicked.setOnClickListener {
            textView.text = getString(R.string.clicks) + (++counter)
            showTaskActivity()
        }
    }

    fun showTaskActivity() {
        val intent = Intent(this, TaskActivity::class.java)
        intent.putExtra("extra.COUNT", counter)
        startActivity(intent)
    }
}
