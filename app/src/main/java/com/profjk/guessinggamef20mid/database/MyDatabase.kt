package com.profjk.guessinggamef20mid.database
import androidx.room.*
import android.content.Context
import com.profjk.guessinggamef20mid.Score

@Database(entities = arrayOf(Score::class), version = 1)
abstract class MyDatabase: RoomDatabase() {

    abstract fun scoreDao() : scoreDao

    companion object{
        private var instance: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase?{
            if (instance == null){
                synchronized(MyDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "MyDB"
                    ).allowMainThreadQueries().build()
                }
            }

            return instance
        }
    }
}