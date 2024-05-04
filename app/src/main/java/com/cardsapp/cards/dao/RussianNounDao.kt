package com.cardsapp.cards.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cardsapp.cards.model.RussianNoun

@Dao
interface RussianNounDao {
    @Insert
    suspend fun insert(russianNoun: RussianNoun)

    @Update
    suspend fun update(russianNoun: RussianNoun)

    @Delete
    suspend fun delete(russianNoun: RussianNoun)

    @Query("SELECT * FROM russianNouns ORDER BY word DESC")
    fun getAll(): LiveData<List<RussianNoun>>

    @Query("SELECT * FROM russianNouns WHERE word = :word")
    fun getByWord(word: String): LiveData<RussianNoun>

    @Query("SELECT * FROM russianNouns WHERE id = :id")
    fun getById(id: Long): LiveData<RussianNoun>

}