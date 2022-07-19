package com.example.myhelloworld

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {

   lateinit var diceImg : ImageView //cannot findViewById here, because haven't set the layout
   lateinit var numberText : TextView
   lateinit var editPlayerName : EditText
   lateinit var playerNameTV : TextView
//    var diceImg : ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImg = findViewById(R.id.diceImage)
        numberText = findViewById(R.id.numberText)
        editPlayerName = findViewById(R.id.editPlayerNameET)
        playerNameTV = findViewById(R.id.playerNameTV)
        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener { rollDice() }
        val updateButton : Button = findViewById(R.id.updatePlayerNameBtn)
        updateButton.setOnClickListener { updatePlayerName(it) }
    }

        private fun rollDice(){
            Toast.makeText(this, "Button Clicked",
            Toast.LENGTH_SHORT).show()

            val randomNum = (1..6).random()

//            val numberText: TextView = findViewById(R.id.numberText)
            numberText.text = randomNum.toString()
//            val diceImg : ImageView = findViewById(R.id.diceImage)
            val imgSrc = when (randomNum){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            diceImg.setImageResource(imgSrc)


            Toast.makeText(this, randomNum.toString(),
                Toast.LENGTH_SHORT).show()
        }

    private fun updatePlayerName(view: View){
        playerNameTV.text = editPlayerName.text

        editPlayerName.text.clear()
        editPlayerName.clearFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}