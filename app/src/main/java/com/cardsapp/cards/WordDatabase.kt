package com.cardsapp.cards

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cardsapp.cards.dao.NounDao
import com.cardsapp.cards.dao.VerbDao
import com.cardsapp.cards.model.Noun
import com.cardsapp.cards.model.Verb

@Database(entities = [Noun::class, Verb::class], version = 1, exportSchema = false)
abstract class WordDatabase: RoomDatabase() {
    abstract val nounDao: NounDao
    abstract val verbDao: VerbDao

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
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}