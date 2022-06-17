package com.example.denisseduchen

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Activity2 : AppCompatActivity() {

    var txtId: EditText?=null
    var txtNombre: EditText?=null
    var txtCorreo: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        supportActionBar?.hide()
        Toast.makeText(applicationContext, "Estás en el Activity 2", Toast.LENGTH_SHORT).show()

        txtId=findViewById(R.id.txtId)
        txtNombre=findViewById(R.id.txtNombre)
        txtCorreo=findViewById(R.id.txtCorreo)


        val btn=findViewById<Button>(R.id.btnAtras)
        btn.setOnClickListener {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }//end listener



    }//end fun

    fun insertar(view: View) {

        //creamos una conexión con la bbdd
        var clase=SQLite(this, "personas", null, 1)
        var bbdd=clase.writableDatabase

        var Id=txtId?.text.toString()
        var Nombre=txtNombre?.text.toString()
        var Correo=txtCorreo?.text.toString()

        if(Id.isEmpty()==false && Nombre.isEmpty()==false && Correo.isEmpty()==false) {
            var lista= ContentValues()
            lista.put("Id", Id)
            lista.put("Nombre", Nombre)
            lista.put("Correo", Correo)

            bbdd.insert("personas",null, lista)
            txtId?.setText("")
            txtNombre?.setText("")
            txtCorreo?.setText("")
            Toast.makeText(this, "Datos insertados", Toast.LENGTH_LONG).show()
        }//fin if
        else {
            Toast.makeText(this, "Los campos no pueden estar vacíos", Toast.LENGTH_LONG).show()
        }//fin else
        bbdd.close()
    }//fin fun


    fun mostrar(view:View) {

        var clase=SQLite(this, "personas", null, 1)
        var bbdd=clase.writableDatabase
        val id=txtId?.text.toString()
        if(id.isNotEmpty()){
            val campo=bbdd.rawQuery("select * from personas where id='$id'", null)
            if(campo.moveToFirst()) {
                txtId?.setText(campo.getString(0))
                txtNombre?.setText(campo.getString(1))
                txtCorreo?.setText(campo.getString(2))
                bbdd.close()
            }//end if

            else {
                Toast.makeText(this, "No existen registros", Toast.LENGTH_SHORT).show()
            }//end else
        }//end mostrar


    }//end onCreate

}//end Activity2