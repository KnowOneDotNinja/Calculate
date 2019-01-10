package ninja.knowone.calculate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClickEvent(view: View) {

        if (isNewOp) {
            clearScreen()
        }
        isNewOp = false
        val btnPressed = view as Button
        var btnValue: String = tvMain.text.toString()
        when (btnPressed.id) {
                btn0.id -> btnValue += "0"
                btn1.id -> btnValue += "1"
                btn2.id -> btnValue += "2"
                btn3.id -> btnValue += "3"
                btn4.id -> btnValue += "4"
                btn5.id -> btnValue += "5"
                btn6.id -> btnValue += "6"
                btn7.id -> btnValue += "7"
                btn8.id -> btnValue += "8"
                btn9.id -> btnValue += "9"
                btnPosNeg.id -> btnValue = "-$btnValue"
                //TODO: Prevent adding more than 1 dot
                btnDot.id -> btnValue += "."
        }
        tvMain.text = btnValue
    }

    var op = ""
    var oldNumber = ""
    var isNewOp = true

    fun btnOpEvent(view: View) {

        val btnPressed = view as Button
        var btnValue: String = tvMain.text.toString()
        when (btnPressed.id) {
            btnAdd.id -> {

                op = "+"
                isNewOp = true
            }
            btnSubtract.id -> {

                op = "-"
                isNewOp = true
            }
            btnMultiply.id -> {

                op = "*"
                isNewOp = true
            }
            btnDivide.id -> {

                op = "/"
                isNewOp = true
            }
        }
        oldNumber = tvMain.text.toString()
    }

    fun btnEqualEvent(view: View) {
        var finalNumber:Double? = null
        val newNumber = tvMain.text.toString().toDouble()
        when (op) {
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber
            }
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber
            }
        }
        tvMain.text = finalNumber.toString()
    }

    fun clearScreen() {
        tvMain.text = ""
    }

    fun btnPercent(view: View) {
        val num = tvMain.text.toString().toDouble()/100
        tvMain.text = num.toString()
        isNewOp = true
    }

    fun allClear(view: View) {
        tvMain.text = ""
        oldNumber = "0"
        op = ""
        isNewOp = true
    }

}
