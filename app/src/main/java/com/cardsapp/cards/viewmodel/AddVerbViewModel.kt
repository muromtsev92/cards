package com.cardsapp.cards.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cardsapp.cards.dao.VerbDao
import com.cardsapp.cards.model.HabenSein
import com.cardsapp.cards.model.Verb
import kotlinx.coroutines.launch

class AddVerbViewModel(val verbDao: VerbDao): ViewModel() {
    var newHabenSein = HabenSein.HAT
    var newGermanInfinitive = ""
    var newGermanPartizipZwei = ""
    var newRussian = ""
    var istChecked = false
    var hatChecked = false


    fun addVerb(){
        viewModelScope.launch {
            val newVerb = Verb()
            setHabenSein()
            newVerb.habenSein = newHabenSein
            newVerb.germanInfinitive = newGermanInfinitive
            newVerb.germanPartizipZwei = newGermanPartizipZwei
            newVerb.russian = newRussian

            verbDao.insert(newVerb)
        }
    }

    private fun setHabenSein(){
        if(istChecked){
            newHabenSein = HabenSein.IST
        }
    }
}