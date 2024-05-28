package com.cardsapp.cards.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.cardsapp.cards.WordDatabase
import com.cardsapp.cards.databinding.FragmentAddVerbBinding
import com.cardsapp.cards.viewmodel.AddVerbViewModel
import com.cardsapp.cards.viewmodel.factories.AddVerbViewModelFactory

class AddVerbFragment: Fragment() {
    private var _binding: FragmentAddVerbBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FragmentAddVerbBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddVerbBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val database = WordDatabase.getInstance(application)
        val verbDao = database.verbDao
        val viewModelFactory = AddVerbViewModelFactory(verbDao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(AddVerbViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.saveVerbButton.setOnClickListener{
            viewModel.addVerb()
            Toast.makeText(context, "The word has been added", Toast.LENGTH_SHORT).show()
            binding.enterGermanInfinitive.setText("")
            binding.enterGermanNewPartizipZwei.setText("")
            binding.enterRussianVerb.setText("")
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}