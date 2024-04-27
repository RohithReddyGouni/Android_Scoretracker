package com.example.scoretracker

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.result)

        if(savedInstanceState != null && savedInstanceState.containsKey("COUNT")) {
            count=savedInstanceState.getInt("COUNT")

            textView.text = count.toString()
            Log.d("Your Activity","The count in onCreate is $count")
        }

    }

    fun incrementScore(view: View) {
        count++
        textView.setText(count.toString())
    }

    fun decrementScore(view: View) {
        count--
        textView.setText(count.toString())
    }


    override fun onSaveInstanceState(outState: Bundle) {

        super.onSaveInstanceState(outState)
        outState.putInt("COUNT",count)
        Log.d("YourActivityName", "The count value is:: $count")
    }


}
/**
 * Wen you create an application, you would get one Activity by default
 * Each activity will have one ".java" file and one ".xml" file
 * .xml file will have the design
 * .java file displays the .xml file to the user and also provides logical support to the design
 */

