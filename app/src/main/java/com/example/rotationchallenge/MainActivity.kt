package com.example.rotationchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set a custom toolbar
        setSupportActionBar(findViewById(R.id.toolbar_custom))

        // Verifies the state of textView to save information in case the screen rotates
        val textCounter = savedInstanceState?.getString("KEY_TEXT") ?: "0"

        val textview = findViewById<TextView>(R.id.textView)

        // Pass to textView the saved state.
        // This line is important to show the right text when there is a rotation.
        // Otherwise the state will be saved but not displayed.
        textview.text = textCounter

        // Setting the button to increment when tapped
        var counter = textCounter.toInt()
        val button = findViewById<Button>(R.id.plus_one_button)
        button.setOnClickListener {
            counter++
            textview.text = counter.toString()
        }
    }

    // This function is responsible to return the saved state to the activity
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Getting the textView text attribute to receive the saved text from textCounter
        val textViewText = findViewById<TextView>(R.id.textView).text.toString()
        outState.putString("KEY_TEXT", textViewText)
    }


    // Inflate the menu on toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // This function defines the actions on menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "It's just a practice app", Toast.LENGTH_SHORT).show()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
}