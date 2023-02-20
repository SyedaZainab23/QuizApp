package com.example.quizapp

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
private lateinit var mediaPlayer: MediaPlayer


override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val buttonClick = findViewById<Button>(R.id.button3)
    buttonClick.setOnClickListener {
        val intent = Intent(this, SecondPage::class.java)
        startActivity(intent)
    }
    mediaPlayer= MediaPlayer.create(this,R.raw.background_music)

    mediaPlayer.start()
    mediaPlayer.isLooping=true

    // Initialize the media player and set the audio file
}

    override fun onPause() {
        super.onPause()
        mediaPlayer.pause()
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }


}