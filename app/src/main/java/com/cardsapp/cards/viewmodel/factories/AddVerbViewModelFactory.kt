package com.cardsapp.cards.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cardsapp.cards.dao.VerbDao

import com.cardsapp.cards.viewmodel.AddVerbViewModel

class AddVerbViewModelFactory (private val verbDao: VerbDao)
    : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddVerbViewModel::class.java)) {
            return AddVerbViewModel(verbDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}