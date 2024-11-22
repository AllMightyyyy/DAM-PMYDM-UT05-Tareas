package org.cesur.eje4

import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the views
        val selectedDayText: TextView = findViewById(R.id.selectedDayText)
        val radioGroupDays: RadioGroup = findViewById(R.id.radioGroupDays)

        // Set a listener for changes in the RadioGroup
        radioGroupDays.setOnCheckedChangeListener { _, checkedId ->
            // Find the selected RadioButton
            val selectedRadioButton: RadioButton = findViewById(checkedId)

            // Update the TextView with the selected day's text
            selectedDayText.text = "PULSADO ${selectedRadioButton.text.toString().uppercase()}"
        }
    }
}
