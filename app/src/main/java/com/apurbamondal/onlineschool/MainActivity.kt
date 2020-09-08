package com.apurbamondal.onlineschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    public fun Register(view: View) {
        startActivity(Intent(this@MainActivity, Register_activity::class.java))
    }
    public fun Login(view: View) {
        startActivity(Intent(this@MainActivity, Login_activity::class.java))
    }
}