package com.example.denisseduchen

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btPlay as btPlay1
import kotlinx.android.synthetic.main.activity_main.btStop as btStop1
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        //creamos el reproductor
        val rep = MediaPlayer.create(this, R.raw.mascleta)

        //creamos el botón de play e iniciamos la canción
        btPlay1.setOnClickListener {
            rep.start()
        }//end btPlay1

        //importamos el botón de stop para parar la canción
        btStop1.setOnClickListener {
            if(rep.isPlaying){
                rep.stop()
            }
        }//end btStop1


        val btAc1=findViewById<Button>(R.id.btnAc1)
        btnAc1.setOnClickListener {
            val intento = Intent(this, Activity2::class.java)
            startActivity(intento)
        }//end listener


        val btAc2=findViewById<Button>(R.id.btnAc2)
        btnAc2.setOnClickListener {
            val intento = Intent(this, Activity3::class.java)
            startActivity(intento)
        }//end listener



        val btAc3=findViewById<Button>(R.id.btnAc3)
        btnAc3.setOnClickListener {
            val intento = Intent(this, Activity4::class.java)
            startActivity(intento)
        }//end listener





    }//end fun


}//end main