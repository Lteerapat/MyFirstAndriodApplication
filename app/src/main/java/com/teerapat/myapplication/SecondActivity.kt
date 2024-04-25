package com.teerapat.myapplication

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi

class SecondActivity : AppCompatActivity() {
    private var sum: Int = 0
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent: Intent = intent
        sum = intent.getIntExtra("result", 0)

        val bundle = intent.getBundleExtra("cBundle")
        val x = bundle?.getInt("x")
        val y = bundle?.getInt("y")
        val z = bundle?.getInt("z")


        // do not use serializable
        val c2 = intent.getSerializableExtra("cSerializable", CoordinateSerializable::class.java)

        val c3 = intent.getParcelableExtra("cParcelable", CoordinateParcelable::class.java)

        initInstances()
    }

    private fun initInstances() {
        val result2 = findViewById<TextView>(R.id.resultTv2)
        result2.text = "Result = $sum"

        val okBtn = findViewById<Button>(R.id.okBtn)
        val intentEt = findViewById<EditText>(R.id.intentEt)
        okBtn.setOnClickListener {
            val returnText = intentEt.text.toString()
            val returnIntent = Intent()
            returnIntent.putExtra("result", returnText)
            setResult(RESULT_OK, returnIntent)
            finish()

        }

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}