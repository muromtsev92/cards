package com.cardsapp.cards.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.cardsapp.cards.dao.NounDao
import com.cardsapp.cards.model.Noun

class ShowAllViewModel(nounDao: NounDao): ViewModel() {
    val words = nounDao.getAll()
}