package texnopos.uz.mathgamerandom
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import java.sql.Time
import kotlin.random.Random
class SecondActivity : AppCompatActivity() {
    var signs = mutableListOf('+', '-', '*', '/')
    var time: Int = 0
    var buttons: MutableList<Button> = mutableListOf()
    private var namePlayer: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        namePlayer = intent.getStringExtra("NamePlayer").toString()
        tvName.text=namePlayer
        inputNumber()
        time = 10
    }
    var timer = object : CountDownTimer(10000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            timertext.setText(time.toString())
            time -= 1
        }
        override fun onFinish() {
            result()
        }
    }
    var score = 0
    var rightAnswer = 0
    fun inputNumber() {
        buttons = mutableListOf(button1, button2, button3, button4)
        buttons.shuffle()
        timer.start()
        var numbers1 = (Random.nextInt(-30, 30))
        var numbers2 = (Random.nextInt(-30, 30))
        firstnumber.text = numbers1.toString()
        secondnumber.text = numbers2.toString()
        var a = (Random.nextInt(0, 3))
        sign.text = signs[a].toString()
        when (a) {
            0 -> rightAnswer = (numbers1 + numbers2)
            1 -> rightAnswer = (numbers1 - numbers2)
            2 -> rightAnswer = (numbers1 * numbers2)
            3 -> rightAnswer = (numbers1 / numbers2)
        }
        buttons[0].text = rightAnswer.toString()
        var numbers3 = Random.nextInt(1, 10)
        buttons[1].text = (buttons[0].text.toString().toInt() - numbers3).toString()
        buttons[2].text = (buttons[0].text.toString().toInt() + numbers3 + numbers3).toString()
        buttons[3].text = (buttons[0].text.toString().toInt() + numbers3).toString()
        tvscore.setText(score.toString())
    }

    fun result() {
        val intent1 = Intent(this, Result::class.java)
        intent1.putExtra("playerName", namePlayer)
        intent1.putExtra("score", score)
        startActivity(intent1)
        finish()
    }

    fun onClickButton(view: View) {
        if ((view as Button).text == buttons[0].text) {
            score++
            timer.cancel()
            time = 10
            inputNumber()
        } else {
            timer.cancel()
            timer.onFinish()
        }
    }

}

