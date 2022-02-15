package org.hyperskill.calculator.tip

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import org.hyperskill.calculator.tip.databinding.ActivityMainBinding

lateinit var bindingClass: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        fun result() {
            var res = (edit_text.text.toString().toDouble() / 100 * slider.value.toString().toDouble())

                text_view.text = "Tip amount: ${"%.2f".format(res)}"
        }
        slider.addOnChangeListener { slider, value, fromUser ->
            if (edit_text.text.toString().length > 0) {
                result()
            }
        }
        edit_text.doOnTextChanged { text, start, before, count ->
            if (edit_text.text.toString().length > 0) {
                result()
            } else text_view.text = ""
        }
    }
}