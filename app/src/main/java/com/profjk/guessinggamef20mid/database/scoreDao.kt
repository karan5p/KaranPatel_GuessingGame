package com.profjk.guessinggamef20mid.database
import androidx.room.*
import com.profjk.guessinggamef20mid.Score

@Dao
interface scoreDao {
    @Insert
    fun insertAll(vararg score: Score)

    @Query("SELECT * FROM score")
    fun getAll() : List<Score>
}