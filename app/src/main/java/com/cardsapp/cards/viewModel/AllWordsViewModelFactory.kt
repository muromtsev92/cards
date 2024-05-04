package com.cardsapp.cards.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cardsapp.cards.dao.GermanNounDao
import com.cardsapp.cards.dao.RussGerNounVcbDao
import com.cardsapp.cards.dao.RussianNounDao

class AllWordsViewModelFactory (val germanNounDao: GermanNounDao,
                                 val russianNounDao: RussianNounDao,
                                 val russGerNounVcbDao: RussGerNounVcbDao
                                ): ViewModelProvider.Factory  {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AllWordsViewModel::class.java)) {
            return AllWordsViewModel(germanNounDao, russianNounDao, russGerNounVcbDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}