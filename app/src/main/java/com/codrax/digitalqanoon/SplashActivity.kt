package com.codrax.digitalqanoon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            openMainActivity()
        }, 5000)

    }

    private fun openMainActivity() {
        val intent1 = Intent(this, WebSite_Activity::class.java)
        val intent2 = Intent(this, MainActivity::class.java)

        val intentArray = arrayOf(intent1, intent2)
        startActivities(intentArray)
        finish()
    }
}