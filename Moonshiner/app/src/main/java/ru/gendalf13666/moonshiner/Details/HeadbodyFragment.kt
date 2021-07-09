package ru.gendalf13666.moonshiner.Details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R

class HeadbodyFragment : Fragment() {

    private var heads_perc: Spinner? = null
    private var spirt_all: TextView? = null
    private var spirt_full: EditText? = null
    private var spirt_heads: TextView? = null
    private var spirt_hvost: TextView? = null
    private var spirt_prod: TextView? = null
    private var spirt_strong: EditText? = null
    private var spirt_strongOut: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_headbody, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val button: Button
        button = requireView().findViewById(R.id.button)
        button.setOnClickListener { raschet_semdrobniy() }

        spirt_strong = getView()?.findViewById(R.id.spirt_strong)
        spirt_full = getView()?.findViewById(R.id.spirt_full)
        spirt_strongOut = getView()?.findViewById(R.id.spirt_strongOut)
        spirt_all = getView()?.findViewById(R.id.spirt_itog_full_rez)
        spirt_heads = getView()?.findViewById(R.id.spirt_itog_heads_rez)
        spirt_prod = getView()?.findViewById(R.id.spirt_itog_prod_rez)
        spirt_hvost = getView()?.findViewById(R.id.spirt_itog_hvost_rez)
        heads_perc = getView()?.findViewById(R.id.heads_perc)
        heads_perc?.setSelection(4)
    }

    fun raschet_semdrobniy() {
        val string2 = spirt_full!!.text.toString()
        val string3 = spirt_strong!!.text.toString()
        val string4 = heads_perc!!.selectedItem.toString()
        val string5 = spirt_strongOut!!.text.toString()
        val d = string2.toDouble()
        val d2 = string3.toDouble()
        val d3 = string4.toDouble()
        val d4 = string5.toDouble()
        val d5 = d * (d2 / 100.0)
        val d6 = d5 * (d3 / 100.0)
        val d7 = 0.15 * d5
        val d8 = d5 - d6 - d7
        var d9 = 0.0
        if (d4 != d9) {
            d9 = d8 + d8 * (100.0 / d4 - 1.0)
        }
        val arrobject = arrayOf<Any>(d5)
        val string6 = String.format("%.3f", *arrobject)
        val arrobject2 = arrayOf<Any>(d6)
        val string7 = String.format("%.3f", *arrobject2)
        val arrobject3 = arrayOf<Any>(d7)
        val string8 = String.format("%.3f", *arrobject3)
        val arrobject4 = arrayOf<Any>(d9)
        val string9 = String.format("%.3f", *arrobject4)
        spirt_all!!.text = string6
        spirt_heads!!.text = string7
        spirt_prod!!.text = string9
        spirt_hvost!!.text = string8
    }
}
