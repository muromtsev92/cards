package com.cardsapp.cards.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cardsapp.cards.dao.NounDao
import com.cardsapp.cards.viewmodel.AddWordViewModel

class AddWordViewModelFactory (private val nounDao: NounDao)
    : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddWordViewModel::class.java)) {
            return AddWordViewModel(nounDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}