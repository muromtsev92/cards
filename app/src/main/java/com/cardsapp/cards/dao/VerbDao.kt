package com.cardsapp.cards.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cardsapp.cards.model.Verb

@Dao
interface VerbDao {
    @Insert
    suspend fun insert(verb: Verb)

    @Update
    suspend fun update(verb: Verb)

    @Delete
    suspend fun delete(verb: Verb)

    @Query("SELECT * FROM verbs ORDER BY id DESC")
    fun getAll(): LiveData<List<Verb>>

    @Query("SELECT * FROM verbs WHERE id = :id")
    fun getById(id: Long): LiveData<Verb>

    @Query("DELETE FROM verbs")
    fun deleteAll()

    @Query("SELECT * FROM verbs ORDER BY RANDOM() LIMIT 10")
    fun getRandomTen(): LiveData<List<Verb>>
}