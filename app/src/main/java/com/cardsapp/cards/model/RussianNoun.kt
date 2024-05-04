package com.cardsapp.cards.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "russianNouns")
data class RussianNoun (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var word: String = ""
)