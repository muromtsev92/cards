package com.cardsapp.cards.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cardsapp.cards.dao.NounDao
import com.cardsapp.cards.model.Noun


class ArticlesViewModel(private val nounDao: NounDao): ViewModel() {


    var inGameWords: LiveData<List<Noun>> = MutableLiveData(nounDao.getRandomTen().value)
    var list = inGameWords.value
    var currentWord = list?.get(0) ?: Noun()
    val displayedWord = MutableLiveData<String>(currentWord.germanSingular ?: "")
    val message = MutableLiveData<String>()
    val wordNumber = MutableLiveData<Int>(0)

    fun checkIfRight(ans: String){
        if (ans.uppercase() == currentWord.article.toString()){
            message.value = "Right, " + currentWord.article.toString().lowercase() + (currentWord.germanSingular
                ?: "") + "!"
        } else {
            message.value = "Wrong, " + currentWord.article.toString().lowercase() + (currentWord.germanSingular
                ?: "") + "!"
        }
    }

    fun nextWord(){
        if(wordNumber.value!! >= 9){
            message.value += "/nEnd"
            return
        }
        wordNumber.value = wordNumber.value?.plus(1)
        currentWord = list.get(wordNumber.value!!)
        displayedWord.value = currentWord?.germanSingular
    }



}