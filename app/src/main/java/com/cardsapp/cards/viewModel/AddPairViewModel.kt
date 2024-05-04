package com.cardsapp.cards.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cardsapp.cards.dao.GermanNounDao
import com.cardsapp.cards.dao.RussGerNounVcbDao
import com.cardsapp.cards.dao.RussianNounDao
import com.cardsapp.cards.model.GermanNoun
import com.cardsapp.cards.model.NominativeArticle
import com.cardsapp.cards.model.RussGerNounVcb
import com.cardsapp.cards.model.RussianNoun
import kotlinx.coroutines.launch


class AddPairViewModel( val germanNounDao: GermanNounDao,
                        val russianNounDao: RussianNounDao,
                        val russGerNounVcbDao: RussGerNounVcbDao): ViewModel() {

    var newGermanNoun: String = ""
    var newRussianNoun: String = ""
    var selectedRadioValue = MutableLiveData<Int>()

    fun addPair(){
        viewModelScope.launch {
            val germanNoun = GermanNoun()
            germanNoun.gender = getArticle()
            germanNoun.singular = newGermanNoun
            germanNounDao.insert(germanNoun)

            val russianNoun = RussianNoun()
            russianNoun.word = newRussianNoun
            russianNounDao.insert(russianNoun)

            val rusId = russianNounDao.getByWord(newRussianNoun).value?.id
            val germanId = germanNounDao.getBySingular(newGermanNoun).value?.id

            val russGerNounVcb = RussGerNounVcb()
            russGerNounVcb.rusId = rusId!!
            russGerNounVcb.gerId = germanId!!
            russGerNounVcbDao.insert(russGerNounVcb)
        }
    }

    private fun getArticle(): NominativeArticle{

        when(selectedRadioValue.value){
            1 -> return NominativeArticle.DER
            2 -> return NominativeArticle.DIE
            3 -> return NominativeArticle.DAS
        }
        return NominativeArticle.NO
    }

}