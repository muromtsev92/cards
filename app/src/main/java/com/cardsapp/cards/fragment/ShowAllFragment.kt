package com.cardsapp.cards.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cardsapp.cards.WordDatabase
import com.cardsapp.cards.adapter.NounItemAdapter
import com.cardsapp.cards.databinding.FragmentShowAllBinding
import com.cardsapp.cards.viewmodel.ShowAllViewModel
import com.cardsapp.cards.viewmodel.factories.ShowAllViewModelFactory

class ShowAllFragment : Fragment() {
    private var _binding: FragmentShowAllBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: FragmentShowAllBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShowAllBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val database = WordDatabase.getInstance(application)
        val nounDao = database.nounDao
        val viewModelFactory = ShowAllViewModelFactory(nounDao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ShowAllViewModel::class.java)

        val adapter = NounItemAdapter()
        binding.nounsList.adapter = adapter

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.words.observe(viewLifecycleOwner, Observer{
            it?.let{
                adapter.data = it
            }
        })

        return view
    }
}