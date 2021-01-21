package com.example.recyclerview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    // Initializing an empty ArrayList to be filled with theList
    var theList: ArrayList<String> = ArrayList()
    private lateinit var myAdapter: ListAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Loads items into the ArrayList
        addItems()

        // Creates a vertical Layout Manager
        rView1.layoutManager = LinearLayoutManager(this)
        // Access the RecyclerView Adapter and load the data into it
        myAdapter = ListAdapter(theList, this)
        rView1.adapter = myAdapter




        btnAdd.setOnClickListener {
            if (idListItem.text.toString() != ""){
                theList.add(idListItem.text.toString())
                myAdapter.notifyDataSetChanged()
            }
        }

    }

    // hide the keyboard
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
    // Adds theList to the empty theList ArrayList
    fun addItems() {
        theList.add("dog")
        theList.add("cat")

    }
}