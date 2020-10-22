//Karan Patel 991519115
package com.profjk.guessinggamef20mid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var correctNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateRandomNumber();

    }
    fun onClick(v: View?){
        var attempts = 5;
        if(v != null){
            when(v.id){
                btnCheck.id->{
                    if(this.validateInfo()){
                        if (attempts >0){
                            this.getGuess()
                            attempts--;
                            tvAttempts.text ="$attempts attempts left";
                        }
                    }
                }
            }
        }
    }

    fun validateInfo() : Boolean{
        if(edtAnswer.text.toString().isEmpty()){
            edtAnswer.error = "Please enter your guess!"
            return false
        }
        return true
    }

    fun getGuess(){
        val alertBuilder = AlertDialog.Builder(this)
       var playerGuess = edtAnswer.text.toString()

        if(correctNumber > Integer.parseInt(playerGuess)){
            Toast.makeText(applicationContext,"The number you have guessed is too LOW.", Toast.LENGTH_SHORT).show()
        }
        if(correctNumber < Integer.parseInt(playerGuess)){
            Toast.makeText(applicationContext,"The number you have guessed is too HIGH.", Toast.LENGTH_SHORT).show()
        }
         if(correctNumber == Integer.parseInt(playerGuess)){
             alertBuilder.setTitle("Result")
             alertBuilder.setMessage("Great! You won the game. \n Do you have to play again?")
             alertBuilder.setPositiveButton(android.R.string.yes){dialog, which -> }// TODO: send user to scoreboard
            Toast.makeText(applicationContext,"Correct. You win.", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun generateRandomNumber() {
        correctNumber = Random().nextInt(25)
    }
}