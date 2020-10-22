//Karan Patel 991519115
package com.profjk.guessinggamef20mid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var correctNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun onClick(v: View?){
        if(v != null){
            when(v.id){
                btnCheck.id->{
                    if(this.validateInfo()){
                        this.getGuess()
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

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun generateRandomNumber() {
        correctNumber = Random().nextInt(25)
    }
}