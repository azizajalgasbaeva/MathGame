package texnopos.uz.mathgamerandom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_score.*
import texnopos.uz.mathgamerandom.data.MyDao
import texnopos.uz.mathgamerandom.data.MyDatabase
import texnopos.uz.mathgamerandom.data.User

class ScoreActivity : AppCompatActivity() {
    private lateinit var dao: MyDao
    var myAdapter = MyAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        scorerecyclerview.adapter = myAdapter
        setData()
    }
    fun setData() {
        dao = MyDatabase.getInstance(this).resultsDao()
        myAdapter.models = dao.getAllResult()
    }
}