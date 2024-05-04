package com.cardsapp.cards.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.cardsapp.cards.WordsDatabase
import com.cardsapp.cards.databinding.FragmentAddPairBinding
import com.cardsapp.cards.viewModel.AddPairViewModel
import com.cardsapp.cards.viewModel.AddPairViewModelFactory

class AddPairFragment : Fragment() {

    private var _binding: FragmentAddPairBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FragmentAddPairBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddPairBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val database = WordsDatabase.getInstance(application)
        val germanNounDao = database.germanNounDao
        val russianNounDao = database.russianNounDao
        val russGerNounVcbDao = database.russGerNounVcbDao
        val viewModelFactory = AddPairViewModelFactory(germanNounDao, russianNounDao, russGerNounVcbDao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(AddPairViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner


        return view
    }

}