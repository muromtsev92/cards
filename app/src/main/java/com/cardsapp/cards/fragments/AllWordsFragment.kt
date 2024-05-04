package com.cardsapp.cards.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.cardsapp.cards.R
import com.cardsapp.cards.WordsDatabase

import com.cardsapp.cards.databinding.FragmentAllWordsBinding
import com.cardsapp.cards.viewModel.AddPairViewModel
import com.cardsapp.cards.viewModel.AddPairViewModelFactory
import com.cardsapp.cards.viewModel.AllWordsViewModel
import com.cardsapp.cards.viewModel.AllWordsViewModelFactory


class AllWordsFragment : Fragment() {

    private var _binding: FragmentAllWordsBinding? = null
    private val binging get() = _binding!!
    private lateinit var viewModel: AllWordsViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllWordsBinding.inflate(inflater, container, false)
        val view = binging.root

        val application = requireNotNull(this.activity).application
        val database = WordsDatabase.getInstance(application)
        val germanNounDao = database.germanNounDao
        val russianNounDao = database.russianNounDao
        val russGerNounVcbDao = database.russGerNounVcbDao
        val viewModelFactory = AllWordsViewModelFactory(germanNounDao, russianNounDao, russGerNounVcbDao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(AllWordsViewModel::class.java)

        binging.viewModel = viewModel
        binging.lifecycleOwner = viewLifecycleOwner

        return view
    }

}