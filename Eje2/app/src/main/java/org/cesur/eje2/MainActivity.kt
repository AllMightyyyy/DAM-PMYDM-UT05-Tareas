package org.cesur.eje1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.cesur.eje2.R

class MainActivity : AppCompatActivity() {

    private var currentScreen = 0 // Tracks the current screen index
    private val totalScreens = 2 // Two consolidated screens

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find navigation buttons and container layout
        val prevButton: Button = findViewById(R.id.prevButton)
        val nextButton: Button = findViewById(R.id.nextButton)
        val contentLayout: LinearLayout = findViewById(R.id.contentLayout)

        // Display the first screen initially
        displayScreen(contentLayout, currentScreen)

        // Set up button click listeners for navigation
        prevButton.setOnClickListener {
            if (currentScreen > 0) {
                currentScreen--
                displayScreen(contentLayout, currentScreen)
            }
        }

        nextButton.setOnClickListener {
            if (currentScreen < totalScreens - 1) {
                currentScreen++
                displayScreen(contentLayout, currentScreen)
            }
        }
    }

    private fun displayScreen(contentLayout: LinearLayout, screenIndex: Int) {
        // Clear previous content
        contentLayout.removeAllViews()

        when (screenIndex) {
            0 -> setupSingleButtonScreen(contentLayout) // Screen 1
            1 -> setupDualButtonScreen(contentLayout) // Screen 2
        }
    }

    // Screen 1: Single button that updates the text
    private fun setupSingleButtonScreen(contentLayout: LinearLayout) {
        val textView = TextView(this).apply {
            text = "BOTÓN SIN PULSAR"
            setTextColor(Color.BLUE)
            textSize = 20f
        }

        val button = Button(this).apply {
            text = "BOTÓN"
            setOnClickListener {
                textView.text = "BOTÓN PULSADO"
                textView.setTextColor(Color.RED)
            }
        }

        contentLayout.addView(textView)
        contentLayout.addView(button)
    }

    // Screen 2: Two buttons that update the text
    private fun setupDualButtonScreen(contentLayout: LinearLayout) {
        val textView = TextView(this).apply {
            text = "BOTONES SIN PULSAR"
            setTextColor(Color.BLACK)
            textSize = 20f
        }

        val button1 = Button(this).apply {
            text = "BOTÓN 1"
            setOnClickListener {
                textView.text = "BOTÓN 1 PULSADO"
                textView.setTextColor(Color.RED)
            }
        }

        val button2 = Button(this).apply {
            text = "BOTÓN 2"
            setOnClickListener {
                textView.text = "BOTÓN 2 PULSADO"
                textView.setTextColor(Color.GREEN)
            }
        }

        contentLayout.addView(textView)
        contentLayout.addView(button1)
        contentLayout.addView(button2)
    }
}
