package com.example.newsapplication.Splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.newsapplication.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finishAffinity()
        }, 2000)
    }

}