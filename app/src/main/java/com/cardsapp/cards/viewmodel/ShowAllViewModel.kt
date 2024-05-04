package com.cardsapp.cards.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.cardsapp.cards.dao.NounDao
import com.cardsapp.cards.model.Noun

class ShowAllViewModel(nounDao: NounDao): ViewModel() {
    private val words = nounDao.getAll()

    val wordsString = words.map {
        formatNouns(it)
    }

    fun formatNouns(nouns: List<Noun>): String {
        return nouns.fold("") {
                str, item -> str + '\n' + formatNoun(item)
        }
    }
    fun formatNoun(noun: Noun): String {
        var str = "ID: ${noun.id}"
        str += "Article:  ${noun.article}"
        str += '\n' + "Name: ${noun.germanPlural}"
        str += '\n' + "Complete: ${noun.russian}" + '\n'
        return str
    }
}