package com.example.tictactoe_04082020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var buttons : Array<Button>
    var turnCount = 0
    var flag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttons = arrayOf(btnR0C0, btnR0C1, btnR0C2, btnR1C0, btnR1C1, btnR1C2, btnR2C0, btnR2C1, btnR2C2)

        for(btn in buttons){
            btn.setOnClickListener(this)
        }

        btnReset.setOnClickListener {
            tvResult.text = "Player X Turn"
            enableAllButtons()
            turnCount = 0
            flag = true
        }
    }

    private fun enableAllButtons() {
        for(btn in buttons){
            btn.isEnabled = true
            btn.text = ""
        }
    }

    override fun onClick(p0: View) {
        turnCount++;
        when (p0.id) {
            R.id.btnR0C0 -> {
                updateValue(btnR0C0, flag)
            }

            R.id.btnR0C1 -> {
                updateValue(btnR0C1, flag)
            }

            R.id.btnR0C2 -> {
                updateValue(btnR0C2, flag)
            }

            R.id.btnR1C0 -> {
                updateValue(btnR1C0, flag)
            }

            R.id.btnR1C1 -> {
                updateValue(btnR1C1, flag)
            }

            R.id.btnR1C2 -> {
                updateValue(btnR1C2, flag)
            }

            R.id.btnR2C0 -> {
                updateValue(btnR2C0, flag)
            }

            R.id.btnR2C1 -> {
                updateValue(btnR2C1, flag)
            }

            R.id.btnR2C2 -> {
                updateValue(btnR2C2, flag)
            }
        }
        flag = !flag
        if(flag){
            tvResult.text = "Player X Turn"
        }
        else{
            tvResult.text = "Player 0 Turn"
        }
        if(turnCount==9){
            tvResult.text = "DRAW"
        }
        checkWinner(!flag)
    }

    private fun checkWinner(b: Boolean) {
        val text = if(b){
            "X"
        }
        else{
            "0"
        }
        var winner = false
        //ROW 1
        if(btnR0C0.text.toString() == text &&  btnR0C1.text.toString() == text && btnR0C2.text.toString() == text){
            winner = true
        }
        // ROW 2
        if(!winner) {
            if (btnR1C0.text.toString() == text && btnR1C1.text.toString() == text && btnR1C2.text.toString() == text) {
                winner = true
            }
        }
        //ROW 3
        if(!winner) {
            if (btnR2C0.text.toString() == text && btnR2C0.text.toString() == text && btnR2C2.text.toString() == text) {
                winner = true
            }
        }

        //COLUMN 1
        if(!winner){
            if (btnR0C0.text.toString() == text && btnR1C0.text.toString() == text && btnR2C0.text.toString() == text) {
                winner = true
            }
        }

        //COLUMN 2
        if(!winner){
            if (btnR0C1.text.toString() == text && btnR1C1.text.toString() == text && btnR2C1.text.toString() == text) {
                winner = true
            }
        }

        //COLUMN 3
        if(!winner){
            if (btnR0C2.text.toString() == text && btnR1C2.text.toString() == text && btnR2C2.text.toString() == text) {
                winner = true
            }
        }

        //DIAGONAL 1
        if(!winner){
            if (btnR0C0.text.toString() == text && btnR1C1.text.toString() == text && btnR2C2.text.toString() == text) {
                winner = true
            }
        }

        //DIAGONAL 2

        if(!winner){
            if (btnR0C2.text.toString() == text && btnR1C1.text.toString() == text && btnR2C0.text.toString() == text) {
                winner = true
            }
        }

        if(winner){
            disableAllButtons()
            tvResult.text = "Player $text Wins"
        }
    }

    private fun updateValue(button: Button, flag : Boolean) {
        if(flag){
            button.text = "X"
        }
        else{
            button.text = "0"
        }
        button.isEnabled = false
    }

    private fun disableAllButtons() {
        for(btn in buttons){
            btn.isEnabled = false
        }
    }
}