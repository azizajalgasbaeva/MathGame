package texnopos.uz.mathgamerandom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.scoreitem.view.*
import texnopos.uz.mathgamerandom.data.User

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    fun populateModel(user: User){
        itemView.tvplayername.text=user.namePlayer.toString()
        itemView.tvresulthighscore.text=user.score.toString()

    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
var view = LayoutInflater.from(parent.context).inflate(R.layout.scoreitem,parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
holder.populateModel(models[position])
    }

    override fun getItemCount()=models.size
    var models: List<User> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
}