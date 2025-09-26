package com.example.renacoffeshop

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge

class Splashscreen : AppCompatActivity() {   // Huruf besar S
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splashscreen)

        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.start()

        Thread {
            try { Thread.sleep(3000) }
            catch (e: InterruptedException) { e.printStackTrace() }
            finally {
                startActivity(Intent(this@Splashscreen, home::class.java))
                finish()
            }
        }.start()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
