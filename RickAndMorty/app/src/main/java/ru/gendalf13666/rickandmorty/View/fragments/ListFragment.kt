package ru.gendalf13666.rickandmorty.View.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import ru.gendalf13666.rickandmorty.Model.Repository
import ru.gendalf13666.rickandmorty.R
import ru.gendalf13666.rickandmorty.View.CharacterAdapter
import ru.gendalf13666.rickandmorty.ViewModel.SharedViewModel
import ru.gendalf13666.rickandmorty.ViewModel.SharedViewModelFactory

class ListFragment : Fragment(R.layout.fragment_list) {

    private val viewModel: SharedViewModel by activityViewModels { SharedViewModelFactory(Repository()) }
    var adapter = CharacterAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listCharactersInEpisode.observe(viewLifecycleOwner, {
            adapter.setCharacters(it)
        })

        recycclerview.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recycclerview.adapter = adapter

        btn_filter.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_filterFragment)
        }

        getNameSearchView()

        viewModel.isFilter.observe(viewLifecycleOwner, {
            txt_reset.visibility = if (it) View.VISIBLE else View.INVISIBLE
        })

        txt_reset.setOnClickListener {
            viewModel.getCharacters(1)
            viewModel.filterValue.value = arrayOf(0, 0)
        }
    }

    private fun getNameSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.getByName(query.toString())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel.getCharacters(1)
    }
}
