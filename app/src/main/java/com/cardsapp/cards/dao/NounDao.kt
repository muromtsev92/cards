package com.cardsapp.cards.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cardsapp.cards.model.Noun

@Dao
interface NounDao {
    @Insert
    suspend fun insert(noun: Noun)

    @Update
    suspend fun update(noun: Noun)

    @Delete
    suspend fun delete(noun: Noun)

    @Query("SELECT * FROM nouns ORDER BY id DESC")
    fun getAll(): LiveData<List<Noun>>

    @Query("SELECT * FROM nouns WHERE id = :id")
    fun getById(id: Long): LiveData<Noun>

    @Query("DELETE FROM nouns")
    fun deleteAll(): Unit
}