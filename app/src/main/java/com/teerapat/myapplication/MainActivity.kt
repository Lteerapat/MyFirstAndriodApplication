package com.teerapat.myapplication

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val resultData = data?.getStringExtra("result")
                Toast.makeText(
                    this@MainActivity,
                    "Data from intent = $resultData",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        if (resources.getBoolean(R.bool.portrait_only)) {
//            //fix screen orientation to portrait
//            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
//        }
        setContentView(R.layout.activity_main)
        initInstances()
//
//        val viewGroup1 = findViewById<CustomViewGroup>(R.id.viewGroup1)
//        val viewGroup2 = findViewById<CustomViewGroup>(R.id.viewGroup2)
//
//        viewGroup1.setButtonText("Hello")
//        viewGroup2.setButtonText("World")
    }

    private fun initInstances() {
        val editText1 = findViewById<EditText>(R.id.numberOneEt)
         val editText2 = findViewById<EditText>(R.id.numberTwoEt)
         val result = findViewById<TextView>(R.id.resultTv)
         val button = findViewById<Button>(R.id.calculateButton)
         val rgOperator = findViewById<RadioGroup>(R.id.rgOperator)
        button.setOnClickListener {
            val num1 = editText1.text.toString().toIntOrNull() ?: 0
            val num2 = editText2.text.toString().toIntOrNull() ?: 0
            val sum = when (rgOperator.checkedRadioButtonId) {
                R.id.rbPlus -> num1 + num2
                R.id.rbMinus -> num1 - num2
                R.id.rbMultiply -> num1 * num2
                R.id.rbDivide -> {
                    if (num2 != 0) {
                        num1 / num2
                    } else {
                        "Error"
                    }
                }

                else -> "Error"
            }
            result.text = sum.toString()

            Log.d("Calculation", "Result = $sum")

            Toast.makeText(this@MainActivity, "Result = $sum", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("result", sum)

            // playground
            val c1 = Coordinate(5, 10, 20)
            val bundle = Bundle()
            bundle.putInt("x", c1.x)
            bundle.putInt("y", c1.y)
            bundle.putInt("z", c1.z)
            intent.putExtra("cBundle", bundle)

            //serializable
            val c2 = CoordinateSerializable()
            c2.x = 5
            c2.x = 10
            c2.z = 20
            intent.putExtra("cSerializable", c2)

            //parcelable
            val c3 = CoordinateParcelable()
            c3.x = 5
            c3.y = 10
            c3.z = 20
            intent.putExtra("cParcelable", c3)
            resultLauncher.launch(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //save everything that want to be return
        // work with outState
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        //work with persistable state
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        //restore
    }
}