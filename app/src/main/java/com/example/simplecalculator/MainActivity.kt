package com.example.simplecalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val CEBtn: Button =findViewById(R.id.r1c1)
        val CBtn: Button =findViewById(R.id.r1c2)
        val BSBtn: Button =findViewById(R.id.r1c3)
        val DivideBtn: Button =findViewById(R.id.r1c4)
        val _7Btn: Button =findViewById(R.id.r2c1)
        val _8Btn: Button =findViewById(R.id.r2c2)
        val _9Btn: Button =findViewById(R.id.r2c3)
        val MultipleBtn: Button =findViewById(R.id.r2c4)
        val _4Btn: Button =findViewById(R.id.r3c1)
        val _5Btn: Button =findViewById(R.id.r3c2)
        val _6Btn: Button =findViewById(R.id.r3c3)
        val MinusBtn: Button =findViewById(R.id.r3c4)
        val _1Btn: Button =findViewById(R.id.r4c1)
        val _2Btn: Button =findViewById(R.id.r4c2)
        val _3Btn: Button =findViewById(R.id.r4c3)
        val PlusBtn: Button =findViewById(R.id.r4c4)
        val ReverseBtn: Button =findViewById(R.id.r5c1)
        val _0Btn: Button =findViewById(R.id.r5c2)
        val DotBtn: Button =findViewById(R.id.r5c3)
        val EqualBtn: Button =findViewById(R.id.r5c4)

        val result: TextView = findViewById(R.id.result)
        val totalText: TextView = findViewById(R.id.total)
        val operation: TextView = findViewById(R.id.operation)

        var total = 0

        CEBtn.setOnClickListener({
            result.text = "0"
        })

        CBtn.setOnClickListener({
            result.text = "0"
            operation.text = ""
            totalText.text = ""
        })

        BSBtn.setOnClickListener({
            if (result.text.length > 1)
                result.text = result.text.subSequence(0, result.text.length - 1)
            else
                result.text = "0"
        })

        _0Btn.setOnClickListener({ result.text = (result.text.toString().toInt() * 10 + 0).toString() })
        _1Btn.setOnClickListener({ result.text = (result.text.toString().toInt() * 10 + 1).toString() })
        _2Btn.setOnClickListener({ result.text = (result.text.toString().toInt() * 10 + 2).toString() })
        _3Btn.setOnClickListener({ result.text = (result.text.toString().toInt() * 10 + 3).toString() })
        _4Btn.setOnClickListener({ result.text = (result.text.toString().toInt() * 10 + 4).toString() })
        _5Btn.setOnClickListener({ result.text = (result.text.toString().toInt() * 10 + 5).toString() })
        _6Btn.setOnClickListener({ result.text = (result.text.toString().toInt() * 10 + 6).toString() })
        _7Btn.setOnClickListener({ result.text = (result.text.toString().toInt() * 10 + 7).toString() })
        _8Btn.setOnClickListener({ result.text = (result.text.toString().toInt() * 10 + 8).toString() })
        _9Btn.setOnClickListener({ result.text = (result.text.toString().toInt() * 10 + 9).toString() })

        fun execute () {
            when (operation.text) {
                "+" -> {
                    total += result.text.toString().toInt()
                }
                "-" -> {
                    total -= result.text.toString().toInt()
                }
                "x" -> {
                    total *= result.text.toString().toInt()
                }
                "/" -> {
                    total /= result.text.toString().toInt()
                }
                else -> {
                    total = result.text.toString().toInt()
                }
            }

            totalText.text = total.toString()
        }

        PlusBtn.setOnClickListener({
            execute()
            result.text = "0"
            operation.text = "+"
        })
        MinusBtn.setOnClickListener({
            execute()
            result.text = "0"
            operation.text = "-"
        })
        MultipleBtn.setOnClickListener({
            execute()
            result.text = "0"
            operation.text = "x"
        })
        DivideBtn.setOnClickListener({
            execute()
            result.text = "0"
            operation.text = "/"
        })
        ReverseBtn.setOnClickListener({
            result.text = (result.text.toString().toInt() * -1).toString()
        })

        EqualBtn.setOnClickListener({
            if (!operation.text.isEmpty()) {
                execute()
                result.text = total.toString()
                operation.text = ""
            }
        })
    }

}