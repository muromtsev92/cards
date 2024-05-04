package com.cardsapp.cards.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "germanNouns")
data class GermanNoun(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var gender: NominativeArticle? = null,
    var singular: String = "",
    var plural: String = ""
)