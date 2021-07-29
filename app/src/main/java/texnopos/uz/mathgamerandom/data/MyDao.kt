package texnopos.uz.mathgamerandom.data

import androidx.room.*

@Dao
interface MyDao {
    @Query("SELECT * FROM result order by score DESC")
    fun getAllResult(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Update
    fun getUserScoreUpdate(vararg users: User)

}