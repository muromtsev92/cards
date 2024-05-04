package com.cardsapp.cards

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cardsapp.cards.dao.NounDao
import com.cardsapp.cards.model.Noun

@Database(entities = [Noun::class], version = 1, exportSchema = false)
abstract class WordDatabase: RoomDatabase() {
    abstract val nounDao: NounDao

    companion object {
        @Volatile
        private var INSTANCE: WordDatabase? = null

        fun getInstance(context: Context): WordDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WordDatabase::class.java,
                        "word_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}