package com.teerapat.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText1 = findViewById<EditText>(R.id.numberOneEt)
        val editText2 = findViewById<EditText>(R.id.numberTwoEt)
        val result = findViewById<TextView>(R.id.resultTv)
        val button = findViewById<Button>(R.id.calculateButton)

        button.setOnClickListener{
            val num1 = editText1.text.toString().toIntOrNull() ?: 0
            val num2 = editText2.text.toString().toIntOrNull() ?: 0
            val sum = num1 + num2
            result.text = sum.toString()
        }

    }
}