package com.cardsapp.cards

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cardsapp.cards.dao.GermanNounDao
import com.cardsapp.cards.dao.RussGerNounVcbDao
import com.cardsapp.cards.dao.RussianNounDao
import com.cardsapp.cards.model.GermanNoun
import com.cardsapp.cards.model.RussGerNounVcb
import com.cardsapp.cards.model.RussianNoun

@Database(entities = [GermanNoun::class, RussianNoun::class, RussGerNounVcb::class], version = 1, exportSchema = false)
abstract class WordsDatabase: RoomDatabase() {
    abstract val germanNounDao: GermanNounDao
    abstract val russianNounDao: RussianNounDao
    abstract val russGerNounVcbDao: RussGerNounVcbDao

    companion object{
        @Volatile
        private var INSTANCE: WordsDatabase? = null

        fun getInstance(context: Context): WordsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        WordsDatabase::class.java,
                        "words_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}