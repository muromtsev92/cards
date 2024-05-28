package com.cardsapp.cards.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.cardsapp.cards.WordDatabase
import com.cardsapp.cards.databinding.FragmentAddNounBinding
import com.cardsapp.cards.viewmodel.AddNounViewModel
import com.cardsapp.cards.viewmodel.factories.AddNounViewModelFactory

class AddNounFragment : Fragment() {
    private var _binding: FragmentAddNounBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FragmentAddNounBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNounBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val database = WordDatabase.getInstance(application)
        val nounDao = database.nounDao
        val viewModelFactory = AddNounViewModelFactory(nounDao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(AddNounViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.saveButton.setOnClickListener{
            viewModel.addNoun()
            Toast.makeText(context, "The word has been added", Toast.LENGTH_SHORT).show()
            binding.enterGermanNounPlural.setText("")
            binding.enterGermanNounSingular.setText("")
            binding.enterRussianNoun.setText("")
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}