package com.example.myapplication
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.PriorityQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class MainActivity2 : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private lateinit var array_list: ArrayList<String>
    private lateinit var set: HashSet<String>
    private lateinit var listView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        array_list = ArrayList()
        array_list.ensureCapacity(20)
        set = HashSet()

        name = findViewById(R.id.name)
        listView = findViewById(R.id.listView)

        findViewById<View>(R.id.refresh).setOnClickListener {
            arrayAdapter.notifyDataSetChanged()
            listView.invalidateViews()
            listView.refreshDrawableState()
        }

        findViewById<View>(R.id.save).setOnClickListener {
            val inputName = name.text.toString().trim()
            if (inputName.isNotEmpty()) {
                set.add(inputName)
                array_list.clear()
                if (array_list.isEmpty()) {
                    array_list.addAll(set)
                    arrayAdapter = ArrayAdapter(this@MainActivity2, android.R.layout.simple_list_item_1, array_list)
                    listView.adapter = arrayAdapter
                } else {
                    listView.visibility = View.GONE
                }
                Toast.makeText(this@MainActivity2, "Inserted", Toast.LENGTH_LONG).show()
            } else {
                name.error = "Enter NAME"
            }
        }
    }
}
