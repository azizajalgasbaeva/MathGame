package texnopos.uz.mathgamerandom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            startbutton.setOnClickListener {
                if(etname.text.toString().isEmpty()){
                    Toast.makeText(this, "Please input your name!!!", Toast.LENGTH_SHORT).show()
                }
                else if(etname.text.toString().isNotEmpty()) {
                    val intent1 = Intent(this, SecondActivity::class.java)
                    intent1.putExtra("NamePlayer", etname.text.toString())
                    startActivity(intent1)
                }
            }
    }
}

