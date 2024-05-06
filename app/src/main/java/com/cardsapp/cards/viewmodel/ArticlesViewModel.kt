package com.cardsapp.cards.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cardsapp.cards.dao.NounDao
import com.cardsapp.cards.model.Noun
import kotlinx.coroutines.launch


class ArticlesViewModel(private val nounDao: NounDao): ViewModel() {

    init {
        viewModelScope.launch {
            var list = List<Noun>(10){Noun()}
                nounDao.getRandomTen().observeForever {
                    list -> inGameWords.value = list

            }

        }
    }

    val inGameWords = MutableLiveData<List<Noun>>()

    var currentWord = inGameWords.value?.get(0)
    val displayedWord = MutableLiveData<String>(currentWord?.germanSingular )
    val message = MutableLiveData<String>()
    val wordNumber = MutableLiveData<Int>(0)

    fun checkIfRight(ans: String){
        if (ans.uppercase() == currentWord?.article.toString()){
            message.value = "Right, " + currentWord?.article.toString().lowercase() + (currentWord?.germanSingular
                ?: "") + "!"
        } else {
            message.value = "Wrong, " + currentWord?.article.toString().lowercase() + (currentWord?.germanSingular
                ?: "") + "!"
        }
    }

    fun nextWord(){
        if(wordNumber.value!! >= 9){
            message.value += "/nEnd"
            return
        }
        wordNumber.value = wordNumber.value?.plus(1)
        currentWord = inGameWords.value?.get(wordNumber.value!!) ?: Noun()
        displayedWord.value = currentWord?.germanSingular
    }



}