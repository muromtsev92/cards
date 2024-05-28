package com.cardsapp.cards.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "verbs")
data class Verb(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var habenSein: HabenSein = HabenSein.HAT,
    var germanInfinitive: String = "",
    var germanPartizipZwei: String = "",
    var russian: String = ""
)