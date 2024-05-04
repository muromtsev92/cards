package com.cardsapp.cards.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cardsapp.cards.dao.GermanNounDao
import com.cardsapp.cards.dao.RussGerNounVcbDao
import com.cardsapp.cards.dao.RussianNounDao

class AllWordsViewModel(val germanNounDao: GermanNounDao,
                        val russianNounDao: RussianNounDao,
                        val russGerNounVcbDao: RussGerNounVcbDao
                        ): ViewModel() {
    var words = germanNounDao.getAll().value.toString()

}