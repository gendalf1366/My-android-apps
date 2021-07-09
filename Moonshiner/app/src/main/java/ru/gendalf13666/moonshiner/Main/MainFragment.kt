package ru.gendalf13666.moonshiner.Main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import ru.gendalf13666.moonshiner.Data.Moonshiner
import ru.gendalf13666.moonshiner.R

class MainFragment : Fragment() {

    private var adapter: MyAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val list = ArrayList<Moonshiner>()
        list.addAll(fillArray(resources.getStringArray(R.array.calculator)))

        mainFragmentRecyclerView.hasFixedSize()
        mainFragmentRecyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = MyAdapter(list, this)
        mainFragmentRecyclerView.adapter = adapter
    }

    private fun fillArray(titleArray: Array<String>): List<Moonshiner> {
        val listItemArray = ArrayList<Moonshiner>()
        for (element in titleArray) {
            val listitem = Moonshiner(element)
            listItemArray.add(listitem)
        }
        return listItemArray
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
