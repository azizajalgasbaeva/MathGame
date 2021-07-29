package texnopos.uz.mathgamerandom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_result.*
import texnopos.uz.mathgamerandom.data.MyDao
import texnopos.uz.mathgamerandom.data.MyDatabase
import texnopos.uz.mathgamerandom.data.User

class Result : AppCompatActivity() {
    private lateinit var dao: MyDao
    var myAdapter = MyAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        dao = MyDatabase.getInstance(this).resultsDao()
        var allUsers = dao.getAllResult()
        val totalQuestions = intent.getIntExtra("questions", 0)
        val player = intent.getStringExtra("playerName").toString()
        val score = intent.getIntExtra("score", 0)
        tvquestions.text = "Total questions: ${totalQuestions}"
        tvscoree.text = "Your score: ${score}"

        fun clickbutton() {
            resultbutton.setOnClickListener {
                var intent1 = Intent(this, ScoreActivity::class.java)
                startActivity(intent1)
                finish()
            }
            restartbutton.setOnClickListener {
                var intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("NamePlayer", player)
                startActivity(intent)
                finish()
            }
        }
        clickbutton()
        if (allUsers.isEmpty()){
            var user = User(
                namePlayer = player,
                score = score
            )
            adDataToDB(user)
            return
        }

        for (i in allUsers.indices) {
            if ((allUsers[i].namePlayer== player) && allUsers[i].score< score) {
                allUsers[i].score=score
                    dao.getUserScoreUpdate(allUsers[i])
               return
            }else if ((allUsers[i].namePlayer== player) && allUsers[i].score>= score){
                dao.getUserScoreUpdate(allUsers[i])
            return
            }

            }
        var user = User(
            namePlayer = player,
            score = score
        )
        adDataToDB(user)
    }

    fun adDataToDB(user: User) {
        dao.insertUser(user)
    }
}
