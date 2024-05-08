package com.cardsapp.cards.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cardsapp.cards.dao.NounDao
import com.cardsapp.cards.model.Noun
import kotlinx.coroutines.launch


class ArticlesViewModel(private val nounDao: NounDao): ViewModel() {

    init {
        viewModelScope.launch {
            var list = List(10){Noun()}
                nounDao.getRandomTen().observeForever {
                    list -> inGameWords.value = list
                    currentWord = list[0]
                    displayedWord.value = list[0].germanSingular
            }
        }
    }

    val inGameWords = MutableLiveData<List<Noun>>()
    var currentWord = inGameWords.value?.get(0)
    var displayedWord = MutableLiveData<String>(currentWord?.germanSingular )
    val message = MutableLiveData<String>()
    val wordNumber = MutableLiveData<Int>(0)
    var gameOver = MutableLiveData<Boolean>(false)

    fun checkIfRight(ans: String){
        if (ans.uppercase() == currentWord?.article.toString()){
            message.value = "Correct, " + currentWord?.article.toString().lowercase() + " " + (currentWord?.germanSingular
                ?: "") + " - " + (currentWord?.russian ?: " ") +  "!"
        } else {
            message.value = "Wrong, " + currentWord?.article.toString().lowercase() + (currentWord?.germanSingular
                ?: "") + " - " + (currentWord?.russian ?: " ") +  "!"
        }
    }

    fun nextWord(){
        message.value = " "
        if(wordNumber.value!! >= 9){
//            displayedWord.value = " "
//            message.value += "End"
            gameOver.value = true
            return
        }
        wordNumber.value = wordNumber.value?.plus(1)
        currentWord = inGameWords.value?.get(wordNumber.value!!) ?: Noun()
        displayedWord.value = currentWord?.germanSingular
    }



}