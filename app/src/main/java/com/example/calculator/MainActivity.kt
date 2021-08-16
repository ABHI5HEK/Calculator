package com.example.calculator

import android.media.VolumeShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var canAddOperation = false
    private var canAddDecimal = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var obj = Calculation()
        btnOne.setOnClickListener(View.OnClickListener {
            expressionTV.append("1")
        })
        btnTwo.setOnClickListener(View.OnClickListener {
            expressionTV.append("2")
        })
        btnThree.setOnClickListener(View.OnClickListener {
            expressionTV.append("3")
        })
        btnFour.setOnClickListener(View.OnClickListener {
            expressionTV.append("4")
        })
        btnFive.setOnClickListener(View.OnClickListener {
            expressionTV.append("5")
        })
        btnSix.setOnClickListener(View.OnClickListener {
            expressionTV.append("6")
        })
        btnSeven.setOnClickListener(View.OnClickListener {
            expressionTV.append("7")
        })
        btnEight.setOnClickListener(View.OnClickListener {
            expressionTV.append("8")
        })
        btnNine.setOnClickListener(View.OnClickListener {
            expressionTV.append("9")
        })
        btnZero.setOnClickListener(View.OnClickListener {
            expressionTV.append("0")
        })
        btnDoubleZero.setOnClickListener(View.OnClickListener {
            expressionTV.append("00")
        })
        decimal.setOnClickListener(View.OnClickListener {
            expressionTV.append(".")
        })
        divide.setOnClickListener(View.OnClickListener {
            var resultString = resultTV.text.toString()
            var expressionString = expressionTV.text.toString()

            if (resultString == "0"){
                resultTV.text = expressionString
                expressionTV.text = ""
            }else{
                var output = obj.divide(resultString,expressionString)
                resultTV.text = output
                expressionTV.text = ""
            }
        })
        multiply.setOnClickListener(View.OnClickListener {
            var resultString = resultTV.text.toString()
            var expressionString = expressionTV.text.toString()

            if (resultString == "0"){
                resultTV.text = expressionString
                expressionTV.text = ""
            }else{
                var output = obj.multiply(resultString,expressionString)
                resultTV.text = output
                expressionTV.text = ""
            }
        })
        subtract.setOnClickListener(View.OnClickListener {
            var resultString = resultTV.text.toString()
            var expressionString = expressionTV.text.toString()

            if (resultString == "0"){
                resultTV.text = expressionString
                expressionTV.text = ""
            }else{
                var output = obj.sub(resultString,expressionString)
                resultTV.text = output
                expressionTV.text = ""
            }
        })
        add.setOnClickListener(View.OnClickListener {
            var resultString = resultTV.text.toString()
            var expressionString = expressionTV.text.toString()

            if (resultString == "0"){
                resultTV.text = expressionString
                expressionTV.text = ""
            }else{
                var output = obj.sum(resultString,expressionString)
                resultTV.text = output
                expressionTV.text = ""
            }
        })
        percent.setOnClickListener(View.OnClickListener {
            var resultString = resultTV.text.toString()
            var expressionString = expressionTV.text.toString()

            if (resultString == "0"){
                resultTV.text = expressionString
                expressionTV.text = ""
            }else{
                var output = obj.percent(resultString,expressionString)
                resultTV.text = output
                expressionTV.text = ""
            }
        })

    }



    fun allClear(view: View) {
        if(view is Button){
            resultTV.text = "0"
            expressionTV.text = ""

        }
    }
    fun back(view: View) {
        val length = expressionTV.length()
        if (length>0)
            expressionTV.text = expressionTV.text.subSequence(0,length-1)
    }
}