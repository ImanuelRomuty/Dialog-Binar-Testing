package com.example.binartaskdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var dialogButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialogButton = findViewById(R.id.diolog_button)
        dialogButton.setOnClickListener {
//            dialogCancel()

            dialogAction()

//            dialogCutomLayout()
        }
    }

    private fun dialogCancel(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog Cancel")
        dialog.setMessage("Bisa ditutup dengan klik bagian luar")
        // kalau pake false nanti tidak bisa ditutup
        dialog.setCancelable(true)
        dialog.show()
    }

    private fun dialogAction(){
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Dialog dengan Button")
        dialog.setMessage("Dialog dengan aksi cuy")
        dialog.setIcon(R.mipmap.ic_launcher)
        dialog.setCancelable(false)
        dialog.setPositiveButton("Positiv Button"){
                dialogInterface, p1 -> Toast.makeText(this,"POSITIV BUTTON CLICK", Toast.LENGTH_LONG).show()
        }

        dialog.setNegativeButton("Negativ Button"){
                dialogInterface, p1 -> Toast.makeText(this,"NEGATIV BUTTON CLICK", Toast.LENGTH_LONG).show()
        }

        dialog.setNeutralButton("Neutral Button"){
                dialogInterface, p1 -> Toast.makeText(this,"NETRAL BUTTON CLICK", Toast.LENGTH_LONG).show()
        }
        dialog.show()
    }

    private fun dialogCutomLayout(){
        val Dialoglayout = LayoutInflater.from(this).inflate(R.layout.custom_layout, null, true)
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(Dialoglayout)
        val dialog = dialogBuilder.create()
        dialog.setCancelable(false)
        val btnTutup = Dialoglayout.findViewById<Button>(R.id.close_button)
        btnTutup.setOnClickListener{
            Toast.makeText(this,"Custom Dialog Closed", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.show()
    }

}