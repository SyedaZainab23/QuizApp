package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val buttonClick = findViewById<Button>(R.id.button3)
    buttonClick.setOnClickListener {
        val intent = Intent(this, SecondPage::class.java)
        startActivity(intent)
    }

    // Initialize the media player and set the audio file
}


}