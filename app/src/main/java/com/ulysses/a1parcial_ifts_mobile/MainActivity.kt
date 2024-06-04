package com.ulysses.a1parcial_ifts_mobile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit private var rgbColor: EditText
    lateinit private var result: TextView
    lateinit private var btnConvert: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnConvert = findViewById(R.id.btnConvert)
        rgbColor = findViewById(R.id.etRgbColor)
        result = findViewById(R.id.tvResult)


        btnConvert.setOnClickListener {
            val color = rgbColor.text.toString()
            val colorArray = color.split(",")
            val red = colorArray[0].toInt()
            val green = colorArray[1].toInt()
            val blue = colorArray[2].toInt()
            val hex = String.format("#%02x%02x%02x", red, green, blue)
            result.setText(hex)
        }
    }



}