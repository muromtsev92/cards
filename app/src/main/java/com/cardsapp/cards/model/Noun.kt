package com.cardsapp.cards.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nouns")
data class Noun(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var article: NominativeArticle = NominativeArticle.NO,
    var germanSingular: String = "",
    var germanPlural: String = "",
    var russian: String = ""
)