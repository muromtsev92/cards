package com.cardsapp.cards.viewmodel

import android.widget.RadioGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cardsapp.cards.dao.NounDao
import com.cardsapp.cards.model.NominativeArticle
import com.cardsapp.cards.model.Noun
import kotlinx.coroutines.launch

class AddWordViewModel(val nounDao: NounDao): ViewModel() {

    var newGermanSingular = ""
    var newGermanPlural = ""
    var newRussian = ""
    var selectedRadioValue = 0

    fun addNoun(){
        viewModelScope.launch {
            val newNoun = Noun()
            newNoun.article = getArticle()
            newNoun.germanSingular = newGermanSingular
            newNoun.germanPlural = newGermanPlural
            newNoun.russian = newRussian
            nounDao.insert(newNoun)
        }
    }


    private fun getArticle(): NominativeArticle{
        when(selectedRadioValue){
            0 -> return NominativeArticle.DER
            1 -> return NominativeArticle.DIE
            2 -> return NominativeArticle.DAS
        }
        return NominativeArticle.NO
    }
}