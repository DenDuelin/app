package com.example.denisseduchen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Activity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        val btn=findViewById<Button>(R.id.btnBack)
        btn.setOnClickListener {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }//end listener
    }
}