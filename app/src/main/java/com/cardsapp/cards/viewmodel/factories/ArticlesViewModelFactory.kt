package com.cardsapp.cards.viewmodel.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cardsapp.cards.dao.NounDao
import com.cardsapp.cards.viewmodel.ArticlesViewModel

class ArticlesViewModelFactory (private val nounDao: NounDao)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticlesViewModel::class.java)) {
            return ArticlesViewModel(nounDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}