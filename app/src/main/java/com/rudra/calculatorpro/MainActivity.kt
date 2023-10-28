package com.rudra.calculatorpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rudra.calculatorpro.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btn0.setOnClickListener {
            binding.display.append("0")
        }

        binding.btn1.setOnClickListener {
            binding.display.append("1")
        }

        binding.btn2.setOnClickListener {
            binding.display.append("2")
        }

        binding.btn3.setOnClickListener {
            binding.display.append("3")
        }

        binding.btn4.setOnClickListener {
            binding.display.append("4")
        }

        binding.btn5.setOnClickListener {
            binding.display.append("5")
        }

        binding.btn6.setOnClickListener {
            binding.display.append("6")
        }

        binding.btn7.setOnClickListener {
            binding.display.append("7")
        }

        binding.btn8.setOnClickListener {
            binding.display.append("8")
        }

        binding.btn9.setOnClickListener {
            binding.display.append("9")
        }

        binding.btnPlus.setOnClickListener {
            binding.display.append("+")
        }

        binding.btnMin.setOnClickListener {
            binding.display.append("-")
        }

        binding.btnMul.setOnClickListener {
            binding.display.append("×")
        }

        binding.btnDiv.setOnClickListener {
            binding.display.append("/")
        }


        binding.btnPoint.setOnClickListener {
            binding.display.append(".")
        }

        binding.btnClear.setOnClickListener {
            binding.display.text = ""
            binding.result.text = ""
        }

        binding.btnBS.setOnClickListener {
            if(binding.display.text.isNotEmpty())
                binding.display.text =  binding.display.text.substring(0, binding.display.text.length - 1)
        }

        binding.calculate.setOnClickListener {
            try {
                val value = binding.display.text.toString().replace('×', '*')
                val expression = ExpressionBuilder(value).build()
                val result = expression.evaluate()

                if (result.isInfinite() || result.isNaN()) {
                    binding.result.text = "Division by zero or invalid calculation"
                } else {
                    binding.result.text = result.toString()
                }
            } catch (e: ArithmeticException) {
                // Handle division by zero exception
                binding.result.text = "Division by zero"
            } catch (e: Exception) {
                // Handle other exceptions that might occur during evaluation
                /*binding.result.text = "Error: ${e.message}"*/

                var message = e.message
                binding.result.text = message?.replace('*', '×')

            }
        }
        
        binding.btnN1.setOnClickListener {
            // TODO:
        }


    }

}