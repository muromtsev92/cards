package com.cardsapp.cards.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.cardsapp.cards.R
import com.cardsapp.cards.WordDatabase
import com.cardsapp.cards.databinding.FragmentAddWordBinding
import com.cardsapp.cards.viewmodel.AddWordViewModel
import com.cardsapp.cards.viewmodel.AddWordViewModelFactory

class AddWordFragment : Fragment() {
    private var _binding: FragmentAddWordBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FragmentAddWordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddWordBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val database = WordDatabase.getInstance(application)
        val nounDao = database.nounDao
        val viewModelFactory = AddWordViewModelFactory(nounDao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(AddWordViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}