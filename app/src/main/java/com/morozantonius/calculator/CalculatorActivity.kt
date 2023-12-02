package com.morozantonius.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class CalculatorActivity : AppCompatActivity() {

    private lateinit var tvZero: TextView
    private lateinit var tvOne: TextView
    private lateinit var tvTwo: TextView
    private lateinit var tvThree: TextView
    private lateinit var tvFour: TextView
    private lateinit var tvFive: TextView
    private lateinit var  tvSix: TextView
    private lateinit var tvSeven: TextView
    private lateinit var tvEight: TextView
    private lateinit var tvNine: TextView
    private lateinit var tvMinus: TextView
    private lateinit var tvPlus: TextView
    private lateinit var tvMul: TextView
    private lateinit var tvDivide: TextView
    private lateinit var tvOpen: TextView
    private lateinit var tvClose: TextView
    private lateinit var tvClear: TextView
    private lateinit var matchOperation: TextView
    private lateinit var resultText: TextView
    private lateinit var tvBack: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        tvZero = findViewById(R.id.tv_zero)
        tvOne = findViewById(R.id.tv_one)
        tvTwo = findViewById(R.id.tv_two)
        tvThree = findViewById(R.id.tv_three)
        tvFour = findViewById(R.id.tv_four)
        tvFive = findViewById(R.id.tv_five)
        tvSix = findViewById(R.id.tv_six)
        tvSeven = findViewById(R.id.tv_seven)
        tvEight = findViewById(R.id.tv_eight)
        tvNine = findViewById(R.id.tv_nine)
        tvMinus = findViewById(R.id.tv_minus)
        tvPlus = findViewById(R.id.tv_plus)
        tvMul = findViewById(R.id.tv_mul)
        tvDivide = findViewById(R.id.tv_divide)
        tvOpen = findViewById(R.id.tv_open)
        tvClose = findViewById(R.id.tv_close)
        tvClear = findViewById(R.id.tv_clear)
        matchOperation = findViewById(R.id.math_operation)
        resultText = findViewById(R.id.result_text)
        tvBack = findViewById(R.id.tv_back)

        tvZero.setOnClickListener { setTextField("0") }
        tvOne.setOnClickListener { setTextField("1") }
        tvTwo.setOnClickListener { setTextField("2") }
        tvThree.setOnClickListener { setTextField("3") }
        tvFour.setOnClickListener { setTextField("4") }
        tvFive.setOnClickListener { setTextField("5") }
        tvSix.setOnClickListener { setTextField("6") }
        tvSeven.setOnClickListener { setTextField("7") }
        tvEight.setOnClickListener { setTextField("8") }
        tvNine.setOnClickListener { setTextField("9") }
        tvMinus.setOnClickListener { setTextField("-") }
        tvPlus.setOnClickListener { setTextField("+") }
        tvMul.setOnClickListener { setTextField("*") }
        tvDivide.setOnClickListener { setTextField("/") }
        tvOpen.setOnClickListener { setTextField("(") }
        tvClose.setOnClickListener { setTextField(")") }

        tvClear.setOnClickListener {
            matchOperation.text = ""
            resultText.text = ""
        }
        tvBack.setOnClickListener {
            val str = matchOperation.text.toString()
            if(str.isNotEmpty())
                matchOperation.text = str.substring(0, str.length - 1)

            resultText.text = ""
        }

        findViewById<TextView>(R.id.tvEquals).setOnClickListener {
            try {

                val ex = ExpressionBuilder(matchOperation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toULong()
                if (result == longRes.toDouble()) {
                    resultText.text = longRes.toString()
                } else {
                }
                resultText.text = result.toString()
            } catch (e: Exception) {
                Log.d("Error", "Notification: ${e.message}")
            }
        }
    }

    fun setTextField(str: String) {
        if(resultText.text != ""){
            matchOperation.text = resultText.text
            resultText.text = ""
        }

        matchOperation.append(str)
    }
}