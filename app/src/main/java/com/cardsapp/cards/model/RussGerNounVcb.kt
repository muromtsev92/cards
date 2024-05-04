package com.cardsapp.cards.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "russGerNounVcb")
data class RussGerNounVcb(
    @PrimaryKey
    var id: Long = 0L,
    var rusId: Long = 0L,
    var gerId: Long = 0L
)
