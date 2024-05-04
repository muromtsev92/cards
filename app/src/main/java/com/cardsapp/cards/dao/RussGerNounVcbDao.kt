package com.cardsapp.cards.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cardsapp.cards.model.RussGerNounVcb

@Dao
interface RussGerNounVcbDao {
    @Insert
    suspend fun insert(russGerNounVcb: RussGerNounVcb)

    @Query("SELECT * FROM russGerNounVcb WHERE id = :id")
    fun getPairById(id: Long): LiveData<RussGerNounVcb>

    @Query("SELECT * FROM russGerNounVcb")
    fun getAllPairs(): LiveData<List<RussGerNounVcb>>

}