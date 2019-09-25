package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
//import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    // lateinit promisse android that the variable will be initialized before we get any operations on it (will not be null)
    private lateinit var diceImage: ImageView

    // In android we don't write code in the construct. It is not inflated before the setContentView method.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(this, "Dice rolled", Toast.LENGTH_SHORT).show()
        }

        diceImage = findViewById(R.id.dice_image)
    }

    private fun rollDice() {
        // random number between 0 and 5 (+1 to turn it into 1 and 6)
        val drawableResource = when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        /* val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString() */

        diceImage.setImageResource(drawableResource)
    }
}
