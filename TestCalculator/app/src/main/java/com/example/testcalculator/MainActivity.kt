package com.example.testcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var selectedOperator = ""
    var oldNumber = ""
    var isNewOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickButtonEvent(view: View) {
        if (isNewOperation) {
            clearNumber()
        }

        isNewOperation = false

        val selelctedButton = view as Button
        val currentNumber: String = showNumber.text.toString()
        val newNumber = setNextCharacter(currentNumber, selelctedButton)
        showNumber.setText(newNumber)
    }

    fun setNextCharacter(oldNumber: String, selectedButton: Button): String {
        var number = oldNumber

        when (selectedButton.id) {
            btn_zero.id -> {
                if (number == "0" || number == "") {
                    number = "0"
                } else {
                    number += "0"
                }
            }

            btn_1.id -> {
                if (number == "0" || number == "") {
                    number = "1"
                } else {
                    number += "1"
                }
            }
            btn_2.id -> {
                if (number == "0" || number == "") {
                    number = "2"
                } else {
                    number += "2"
                }
            }
            btn_3.id -> {
                if (number == "0" || number == "") {
                    number = "3"
                } else {
                    number += "3"
                }
            }

            btn_4.id -> {
                if (number == "0" || number == "") {
                    number = "4"
                } else {
                    number += "4"
                }
            }

            btn_5.id -> {
                if (number == "0" || number == "") {
                    number = "5"
                } else {
                    number += "5"
                }
            }

            btn_6.id -> {
                if (number == "0" || number == "") {
                    number = "6"
                } else {
                    number += "6"
                }
            }

            btn_7.id -> {
                if (number == "0" || number == "") {
                    number = "7"
                } else {
                    number += "7"
                }
            }

            btn_8.id -> {
                if (number == "0" || number == "") {
                    number = "8"
                } else {
                    number += "8"
                }
            }

            btn_9.id -> {
                if (number == "0" || number == "") {
                    number = "9"
                } else {
                    number += "9"
                }
            }

            btn_dot.id -> {
                // todo : prevent user to add more than one dot
                if (number == "") {
                    number = "0."
                } else {
                   if(number.indexOf('.') == -1){
                       number += "."
                   }
                }
            }

            btn_sign.id -> {
                if (number == "0" || number == "") {
                    number = "0"
                } else {
                    if (number.first() == '-') {
                        number = number.substring(1, number.lastIndex + 1)
                    } else {
                        number = "-$number"
                    }
                }
            }
        }

        return number
    }

    fun operationEvent(view: View) {
        val selectedButton = view as Button
        when (selectedButton.id) {
            btn_divide.id -> {
                selectedOperator = "/"
            }
            btn_multiple.id -> {
                selectedOperator = "*"
            }
            btn_minus.id -> {
                selectedOperator = "-"
            }
            btn_plus.id -> {
                selectedOperator = "+"
            }
        }

        isNewOperation = true
        oldNumber = showNumber.text.toString()
    }

    fun equalEvent(view: View) {
        view as Button
        val newNumber = showNumber.text.toString().toDouble()
        var answer: Double? = null
        if(selectedOperator != "" && oldNumber != ""){
            when (selectedOperator) {
                "/" -> {
                    answer = oldNumber.toDouble() / newNumber
                }
                "*" -> {
                    answer = oldNumber.toDouble() * newNumber
                }
                "+" -> {
                    answer = oldNumber.toDouble() + newNumber
                }
                "-" -> {
                    answer = oldNumber.toDouble() - newNumber
                }
            }

            showNumber.text = answer.toString()
            isNewOperation = true
            oldNumber = ""
            selectedOperator = ""
        }
    }

    fun percentageEvent(view:View){
        view as Button
        val number = showNumber.text.toString().toDouble()
        val percentage = number / 100
        showNumber.setText(percentage.toString())
        isNewOperation = true
    }

    fun clearInput(view:View){
        view as Button
        clearNumber()
        isNewOperation = true
        selectedOperator = ""
    }

    fun clearNumber() {
        showNumber.setText("0")
    }
}
