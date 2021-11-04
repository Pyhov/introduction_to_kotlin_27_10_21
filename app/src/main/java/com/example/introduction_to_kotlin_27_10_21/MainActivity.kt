package com.example.introduction_to_kotlin_27_10_21

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


private const val POEM_OWN_LOG_TAG = "PoemOwnLog"
private const val ACTIVITY_OWN_LOG_TAG = "ActivityOwnLog"
private const val NUMBER_LINE = "numberline"

class MainActivity : AppCompatActivity() {
    private lateinit var numberLabel: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberLabel = findViewById(R.id.labelNumer)
        if (savedInstanceState != null) {
            //Добавляю 1 так как onSaveInstanceState вызывается раньше чем onDestroy
            numberLabel.text = (savedInstanceState.getInt(NUMBER_LINE) + 1).toString()

        } else {
            numberLabel.text = 0.toString()
        }
        printNextLinePoem("onCreate")
    }

    override fun onStart() {
        super.onStart()
        printNextLinePoem("onStart")
    }

    override fun onPause() {
        super.onPause()
        printNextLinePoem("onPause")
    }

    override fun onStop() {
        super.onStop()
        printNextLinePoem("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        printNextLinePoem("onRestart")
    }

    override fun onResume() {
        super.onResume()
        printNextLinePoem("onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        printNextLinePoem("onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(NUMBER_LINE, this.numberLabel.text.toString().toInt())
        Log.d(ACTIVITY_OWN_LOG_TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)

    }

    private fun printNextLinePoem(state: String) {
        var message:String =""
        var currentLine: Int = this.numberLabel.text.toString().toInt()
        if (currentLine <= getString(R.string.poem).lines().size - 1) {
            message =getLinePoem(currentLine)
            currentLine++
        } else {
            message ="--Стих закончен--"
            currentLine = 0
        }
        Log.d(POEM_OWN_LOG_TAG, "$state()    $message")
        numberLabel.text = currentLine.toString()
    }

    private fun getLinePoem(index: Int): String {

        return getString(R.string.poem).lines()[index]

    }
}