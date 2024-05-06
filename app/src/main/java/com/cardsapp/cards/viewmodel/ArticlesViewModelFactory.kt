package com.cardsapp.cards.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cardsapp.cards.dao.NounDao

class ArticlesViewModelFactory (private val nounDao: NounDao)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticlesViewModel::class.java)) {
            return ArticlesViewModel(nounDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}