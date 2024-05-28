package com.cardsapp.cards.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cardsapp.cards.dao.NounDao
import com.cardsapp.cards.model.NominativeArticle
import com.cardsapp.cards.model.Noun
import kotlinx.coroutines.launch

class AddNounViewModel(val nounDao: NounDao): ViewModel() {

    var newArticle = NominativeArticle.NO
    var newGermanSingular = ""
    var newGermanPlural = ""
    var newRussian = ""
    var derChecked = false
    var dieChecked = false
    var dasChecked = false


    fun addNoun(){
        viewModelScope.launch {
            val newNoun = Noun()
            setArticle()
            newNoun.article = newArticle
            newNoun.germanSingular = newGermanSingular
            newNoun.germanPlural = newGermanPlural
            newNoun.russian = newRussian

            nounDao.insert(newNoun)
        }
    }

    private fun setArticle(){
        if(derChecked){
            newArticle = NominativeArticle.DER
        } else if (dieChecked){
            newArticle = NominativeArticle.DIE
        } else if (dasChecked){
            newArticle = NominativeArticle.DAS
        }
        // TODO: toast notification if not selected
    }

}