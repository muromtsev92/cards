package com.cardsapp.cards.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.cardsapp.cards.WordDatabase
import com.cardsapp.cards.viewmodel.ArticlesViewModel
import com.cardsapp.cards.databinding.FragmentArticlesBinding
import com.cardsapp.cards.viewmodel.AddWordViewModel
import com.cardsapp.cards.viewmodel.AddWordViewModelFactory
import com.cardsapp.cards.viewmodel.ArticlesViewModelFactory

class ArticlesFragment : Fragment() {
    private var _binding: FragmentArticlesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ArticlesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticlesBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val database = WordDatabase.getInstance(application)
        val nounDao = database.nounDao
        val viewModelFactory = ArticlesViewModelFactory(nounDao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ArticlesViewModel::class.java)

        viewModel.gameOver.observe(viewLifecycleOwner, Observer {
            newValue -> if (newValue){
                val action = ArticlesFragmentDirections.actionArticlesFragmentToSummaryFragment()
                view.findNavController().navigate(action)
            }
        })

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}