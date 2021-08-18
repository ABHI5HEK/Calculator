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
            hiddenExpression.append("1")
            canAddOperation = true
        })
        btnTwo.setOnClickListener(View.OnClickListener {
            expressionTV.append("2")
            hiddenExpression.append("2")
            canAddOperation = true
        })
        btnThree.setOnClickListener(View.OnClickListener {
            expressionTV.append("3")
            hiddenExpression.append("3")
            canAddOperation = true
        })
        btnFour.setOnClickListener(View.OnClickListener {
            expressionTV.append("4")
            hiddenExpression.append("4")
            canAddOperation = true
        })
        btnFive.setOnClickListener(View.OnClickListener {
            expressionTV.append("5")
            hiddenExpression.append("5")
            canAddOperation = true
        })
        btnSix.setOnClickListener(View.OnClickListener {
            expressionTV.append("6")
            hiddenExpression.append("6")
            canAddOperation = true
        })
        btnSeven.setOnClickListener(View.OnClickListener {
            expressionTV.append("7")
            hiddenExpression.append("7")
            canAddOperation = true
        })
        btnEight.setOnClickListener(View.OnClickListener {
            expressionTV.append("8")
            hiddenExpression.append("8")
            canAddOperation = true
        })
        btnNine.setOnClickListener(View.OnClickListener {
            expressionTV.append("9")
            hiddenExpression.append("9")
            canAddOperation = true
        })
        btnZero.setOnClickListener(View.OnClickListener {
            expressionTV.append("0")
            hiddenExpression.append("0")
            canAddOperation = true
        })
        btnDoubleZero.setOnClickListener(View.OnClickListener {
            expressionTV.append("00")
            hiddenExpression.append("00")
            canAddOperation = true
        })
        decimal.setOnClickListener(View.OnClickListener {
            if (canAddDecimal){
                expressionTV.append(".")
                hiddenExpression.append(".")
                canAddDecimal = false
                canAddOperation = false
            }
        })
        divide.setOnClickListener(View.OnClickListener {
            var resultString = resultTV.text.toString()
            var expressionString = expressionTV.text.toString()
            var hiddenExpressionString = hiddenExpression.text.toString()

            if (canAddOperation){
                if (resultString == "0"){
                    resultTV.text = hiddenExpressionString
                    expressionTV.text=""
                    hiddenExpression.text = ""
                    canAddOperation = false
                    canAddDecimal = true
                }else{
                    var output = obj.divide(resultString,hiddenExpressionString)
                    resultTV.text = output
                    canAddOperation = false
                    canAddDecimal = true
                    hiddenExpression.text = ""
                    expressionTV.append("/")
                }
            }
        })
        multiply.setOnClickListener(View.OnClickListener {
            var resultString = resultTV.text.toString()
            var expressionString = expressionTV.text.toString()
            var hiddenExpressionString = hiddenExpression.text.toString()

            if (canAddOperation){
                if (resultString == "0"){
                    resultTV.text = hiddenExpressionString
                    expressionTV.text=""
                    hiddenExpression.text = ""
                    canAddOperation = false
                    canAddDecimal = true
                }else{
                    var output = obj.multiply(resultString,hiddenExpressionString)
                    resultTV.text = output
                    canAddOperation = false
                    canAddDecimal = true
                    hiddenExpression.text = ""
                    expressionTV.append("X")
                }
            }
        })
        subtract.setOnClickListener(View.OnClickListener {
            var resultString = resultTV.text.toString()
            var expressionString = expressionTV.text.toString()
            var hiddenExpressionString = hiddenExpression.text.toString()

            if (canAddOperation){
                if (resultString == "0"){
                    resultTV.text = hiddenExpressionString
                    expressionTV.text=""
                    hiddenExpression.text = ""
                    canAddOperation = false
                    canAddDecimal = true
                }else{
                    var output = obj.sub(resultString,hiddenExpressionString)
                    resultTV.text = output
                    canAddOperation = false
                    canAddDecimal = true
                    expressionTV.append("-")
                    hiddenExpression.text = ""
                }
            }
        })
        add.setOnClickListener(View.OnClickListener {
            var resultString = resultTV.text.toString()
            var expressionString = expressionTV.text.toString()
            var hiddenExpressionString = hiddenExpression.text.toString()

            if(canAddOperation){
                if (resultString == "0"){
                    resultTV.text = hiddenExpressionString
                    expressionTV.text=""
                    hiddenExpression.text = ""
                    canAddOperation = false
                    canAddDecimal = true
                }else{
                    var output = obj.sum(resultString,hiddenExpressionString)
                    resultTV.text = output
                    canAddOperation = false
                    canAddDecimal = true
                    hiddenExpression.text = ""
                    expressionTV.append("+")
            }

            }
        })
        percent.setOnClickListener(View.OnClickListener {
            var resultString = resultTV.text.toString()
            var expressionString = expressionTV.text.toString()
            var hiddenExpressionString = hiddenExpression.text.toString()

            if (canAddOperation){
                if (resultString == "0"){
                    resultTV.text = hiddenExpressionString
                    expressionTV.text=""
                    hiddenExpression.text = ""
                    canAddOperation = false
                    canAddDecimal = true
                }else{
                    var output = obj.percent(resultString,hiddenExpressionString)
                    resultTV.text = output
                    canAddOperation = false
                    canAddDecimal = true
                    hiddenExpression.text = ""
                    expressionTV.append("%")
                }
            }
        })
        equalTo.setOnClickListener(View.OnClickListener {
            if(resultTV.text == "0" || resultTV.text =="00"|| resultTV.text == ""){
                resultTV.text = hiddenExpression.text
                expressionTV.text = resultTV.text
                hiddenExpression.text = ""
                canAddDecimal = true
            }else{
                expressionTV.text = resultTV.text
                hiddenExpression.text = resultTV.text
                canAddDecimal = true
            }
        })

    }



    fun allClear(view: View) {
        if(view is Button){
            resultTV.text = "0"
            expressionTV.text = ""
            hiddenExpression.text = ""
            canAddOperation = false

        }
    }
    fun back(view: View) {
        val length = expressionTV.length()
        if (length>0) {
            expressionTV.text = expressionTV.text.subSequence(0, length - 1)
            hiddenExpression.text = hiddenExpression.text.subSequence(0, length - 1)
        }
    }
}