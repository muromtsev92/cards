package com.cardsapp.cards

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cardsapp.cards.dao.NounDao

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
                        "tasks_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}