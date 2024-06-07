package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.ViewCompat
import com.google.android.filament.View

class MainActivity : AppCompatActivity() {
    private lateinit var btnActTwo: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnActTwo = findViewById(R.id.btnActTwo)
        btnActTwo.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val editText: EditText = findViewById(R.id.writeitem)
        val button: Button = findViewById(R.id.addtolist)
        val listView: ListView = findViewById(R.id.list_item)
        val itemlist = arrayListOf<String>()
                button.setOnClickListener {
                    itemlist.add(editText.text.toString())

                    listView.adapter = ArrayAdapter<String>(
                        this, android.R.layout.simple_list_item_1,
                        itemlist
                    )
                }
                        listView . setOnItemClickListener { adapterView, view, i, lMap ->
                    Toast.makeText(
                        this, "you click on" + itemlist.get(i), Toast.LENGTH_SHORT
                    ).show()
                }

            

    }
}    