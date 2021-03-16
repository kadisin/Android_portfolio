package com.example.zad2_v2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)


        var modalItems: Modal = intent.getSerializableExtra("data") as Modal;

        modalItems.name?.let { Log.e("name", it) }

        var viewName = findViewById<TextView>(R.id.viewName)
        var viewImage = findViewById<ImageView>(R.id.viewImage)

        viewName.text = modalItems.name;
        viewImage.setImageResource(modalItems.image!!);


        val button_powieksz = findViewById<Button>(R.id.powiekszButton)
        button_powieksz.setOnClickListener {
            val x = viewImage.getScaleX()
            val y = viewImage.getScaleY()
            viewImage.scaleX = x+0.1f
            viewImage.scaleY = y+0.1f
        }

        val button_pomniejsz = findViewById<Button>(R.id.pomniejszButton)
        button_pomniejsz.setOnClickListener {
            val x = viewImage.getScaleX()
            val y = viewImage.getScaleY()
            viewImage.scaleX = x-0.1f
            viewImage.scaleY = y-0.1f
        }



        val button_przezr_plus = findViewById<Button>(R.id.przezrButton)
        val button_nieprzezr_plus = findViewById<Button>(R.id.nieprzezrButton)

        button_nieprzezr_plus.setOnClickListener{
            var alpha = viewImage.imageAlpha
            if(alpha > 0){
                alpha -= 10
            }
            viewImage.setImageAlpha(alpha)
            Log.d("xD",alpha.toString())
        }
        button_przezr_plus.setOnClickListener{
            var alpha = viewImage.imageAlpha
            if(alpha < 255){
                alpha += 10
            }
            viewImage.setImageAlpha(alpha)
            Log.d("xD",alpha.toString())
        }


    }
}