package com.example.gkline.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }



    fun buNumberEvent(view: View){
        if(isNewOperation){
            editText.setText("")
        }

        isNewOperation = false

        val buSelect= view as Button
        var buClickValue: String=editText.text.toString()
        when(buSelect.id){
            zero_button.id-> {
                buClickValue +=  "0"
            }
            one_button.id-> {
                buClickValue +=  "1"
            }
            two_button.id->{
                buClickValue +=  "2"
            }
            three_button.id-> {
                buClickValue +=  "3"
            }
            four_button.id-> {
                buClickValue +=  "4"
            }
            five_button.id->{
                buClickValue +=  "5"
            }
            six_button.id-> {
                buClickValue +=  "6"
            }
            seven_button.id-> {
                buClickValue +=  "7"
            }
            eight_button.id->{
                buClickValue += "8"
            }
            nine_button.id->{
                buClickValue += "9"
            }
            decimal_button.id->{
                //Todo: prevent adding more than one decimal
                buClickValue += "."
            }
            plusMinus_button.id->{
                buClickValue="-" + buClickValue
            }

        }
        editText.setText(buClickValue)

    }
    var op = "*"
    var oldNumber = ""
    var isNewOperation = true

    fun buOpEvent(view: View) {

        val buSelect = view as Button
        when (buSelect.id) {
            times_button.id -> {
                op = "*"
            }
            divide_button.id -> {
                op = "/"
            }

            minus_button.id -> {
                op = "-"
            }
            plus_button.id -> {
                op = "+"
            }
        }
        oldNumber = editText.text.toString()
        isNewOperation = true
    }

    fun buEqualEvent(view: View){
        val newNumber=editText.text.toString()
        var finalNumber: Double? = null
        when(op){
            "*" -> {
                finalNumber= oldNumber.toDouble() *newNumber.toDouble()
            }
            "/" -> {
                finalNumber= oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                finalNumber= oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalNumber= oldNumber.toDouble() + newNumber.toDouble()
            }
        }


        editText.setText(finalNumber.toString())
        isNewOperation = true
    }

    fun buPercent(view: View){

        val number:Double = editText.text.toString().toDouble() /100
        editText.setText(number.toString())
        isNewOperation = true
    }

    fun buClearEvent(view: View) {
        editText.setText("0")
        isNewOperation = true
    }
}


