package org.cesur.eje3

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentScreen = 0 // Tracks the current screen index
    private val totalScreens = 4 // Total number of screens

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

        // Create an EditText dynamically
        val editText = EditText(this).apply {
            hint = "Enter text here"
            textSize = 18f
            setPadding(16, 16, 16, 16)
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        // Set the inputType based on the screen index
        when (screenIndex) {
            0 -> { // Screen 1: Numeric keyboard
                editText.inputType = InputType.TYPE_CLASS_NUMBER
            }
            1 -> { // Screen 2: Phone keyboard
                editText.inputType = InputType.TYPE_CLASS_PHONE
            }
            2 -> { // Screen 3: Text keyboard
                editText.inputType = InputType.TYPE_CLASS_TEXT
            }
            3 -> { // Screen 4: Numeric password keyboard
                editText.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_PASSWORD
            }
        }

        // Add the EditText to the content layout
        contentLayout.addView(editText)
    }
}
