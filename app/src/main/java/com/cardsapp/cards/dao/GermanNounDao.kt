package com.cardsapp.cards.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cardsapp.cards.model.GermanNoun

@Dao
interface GermanNounDao {
    @Insert
    suspend fun insert(germanNoun: GermanNoun)

    @Update
    suspend fun update(germanNoun: GermanNoun)

    @Delete
    suspend fun delete(germanNoun: GermanNoun)

    @Query("SELECT * FROM germanNouns ORDER BY singular DESC")
    fun getAll(): LiveData<List<GermanNoun>>

    @Query("SELECT * FROM germanNouns WHERE singular = :singular")
    fun getBySingular(singular: String): LiveData<GermanNoun>

    @Query("SELECT * FROM germanNouns WHERE id = :id")
    fun getById(id: Long): LiveData<GermanNoun>


}