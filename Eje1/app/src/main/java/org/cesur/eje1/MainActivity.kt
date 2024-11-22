package org.cesur.eje1

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentScreen = 0 // Tracks the current screen index
    private val totalScreens = 4 // Total number of screens

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_main)

        // Find navigation buttons and container layout
        val prevButton: Button = findViewById(R.id.prevButton)
        val nextButton: Button = findViewById(R.id.nextButton)
        val contentLayout: LinearLayout = findViewById(R.id.contentLayout)

        // Display the first screen initially
        displayScreen(contentLayout, currentScreen)

        // Set up button click listeners
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

        // Generate content dynamically based on screen index
        when (screenIndex) {
            0 -> { // Screen 1: Text created from XML
                val textView = TextView(this).apply {
                    text = "Texto construido desde el XML\nTamaño 20dp, Bold y color Red"
                    setTextColor(Color.RED)
                    textSize = 20f
                    setTypeface(typeface, Typeface.BOLD)
                }
                contentLayout.addView(textView)
            }
            1 -> { // Screen 2: Text created programmatically in Java
                val textView = TextView(this).apply {
                    text = "Texto construido desde Java\nTamaño 20dp, Italic y color Blue"
                    setTextColor(Color.BLUE)
                    textSize = 20f
                    setTypeface(typeface, Typeface.ITALIC)
                }
                contentLayout.addView(textView)
            }
            2 -> { // Screen 3: XML text + appended text from Java
                val textView = TextView(this).apply {
                    text = "Texto construido desde XML\nTexto añadido con Append desde Java"
                    setTextColor(Color.BLACK)
                    textSize = 20f
                }
                contentLayout.addView(textView)
            }
            3 -> { // Screen 4: Custom font and specific text
                val textView = TextView(this).apply {
                    text = "TEXTO ESCRITO FUENTE UMBRELLA"
                    setTextColor(Color.RED)
                    textSize = 20f
                    typeface = Typeface.SERIF
                }
                contentLayout.addView(textView)
            }
        }
    }
}
