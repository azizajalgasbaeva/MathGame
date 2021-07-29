package texnopos.uz.mathgamerandom.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var namePlayer: String,
    var score: Int
)