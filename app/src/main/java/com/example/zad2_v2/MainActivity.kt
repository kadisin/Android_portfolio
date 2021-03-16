package com.example.zad2_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val btn_info = findViewById(R.id.button_info) as Button
        val btn_hobby = findViewById(R.id.button_hobby) as Button
        val btn_grid = findViewById(R.id.button_grid) as Button

        btn_info.setOnClickListener {
            openActivityInfo()
        }
        btn_hobby.setOnClickListener {
            openActivityHobby()

        }
        btn_grid.setOnClickListener {
            openActivityGrid()

        }

    }

    fun openActivityInfo()
    {
        val settings = Intent(this, ActivityInfo::class.java)
        startActivity(settings)
    }

    fun openActivityHobby()
    {
        val settings = Intent(this, ActivityHobby::class.java)
        startActivity(settings)
    }

    fun openActivityGrid()
    {
        val settings = Intent(this, ActivityGrid::class.java)
        startActivity(settings)
    }

}