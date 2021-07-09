package ru.gendalf13666.moonshiner.Details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R

class NapitokFragment : Fragment() {

    private var litr_itog: EditText? = null
    private var raschet: Button? = null
    private var sem_result: TextView? = null
    private var sem_result2: TextView? = null
    private var spirt_full: EditText? = null
    private var spirt_itog: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_napitok, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var button: Button? = null
        raschet = getView()?.findViewById<Button>(R.id.raschet).also {
            if (it != null) {
                button = it
            }
        }
        button!!.setOnClickListener { raschet_napitok() }
        spirt_full = getView()?.findViewById(R.id.spirt_full)
        spirt_itog = getView()?.findViewById(R.id.spirt_itog)
        litr_itog = getView()?.findViewById(R.id.litr_itog)
        sem_result = getView()?.findViewById(R.id.sem_result)
        sem_result2 = getView()?.findViewById(R.id.sem_result2)
    }

    fun raschet_napitok() {
        val string2 = spirt_full!!.text.toString()
        val string3 = spirt_itog!!.text.toString()
        val string4 = litr_itog!!.text.toString()
        val d = string2.toDouble()
        val d2 = string3.toDouble()
        val d3 = string4.toDouble()
        val arrd = doubleArrayOf(
            0.9982,
            0.9967,
            0.9953,
            0.9938,
            0.9924,
            0.991,
            0.9897,
            0.9884,
            0.9872,
            0.9859,
            0.9847,
            0.9836,
            0.9824,
            0.9812,
            0.98,
            0.9789,
            0.9778,
            0.9768,
            0.9759,
            0.9746,
            0.9736,
            0.9725,
            0.9714,
            0.9703,
            0.9692,
            0.9681,
            0.967,
            0.9658,
            0.9646,
            0.9634,
            0.9622,
            0.961,
            0.9597,
            0.9584,
            0.957,
            0.9556,
            0.9542,
            0.9527,
            0.9512,
            0.9496,
            0.948,
            0.9464,
            0.9448,
            0.9431,
            0.9413,
            0.9395,
            0.9377,
            0.9359,
            0.934,
            0.9321,
            0.9302,
            0.9282,
            0.9262,
            0.9242,
            0.9221,
            0.92,
            0.9179,
            0.9157,
            0.9136,
            0.9114,
            0.9091,
            0.9069,
            0.9046,
            0.9023,
            0.9,
            0.8976,
            0.8952,
            0.8928,
            0.8904,
            0.888,
            0.8855,
            0.883,
            0.8805,
            0.8779,
            0.8754,
            0.8728,
            0.8701,
            0.8675,
            0.8648,
            0.862,
            0.8593,
            0.8565,
            0.8537,
            0.8508,
            0.8479,
            0.8449,
            0.8419,
            0.8389,
            0.8357,
            0.8325,
            0.8292,
            0.8259,
            0.8224,
            0.8189,
            0.8152,
            0.8114,
            0.8075,
            0.8033,
            0.799,
            0.7942,
            0.7892
        )
        val d4 = d3 * (d2 / d)
        val d5 = d4 / 1.0
        val d6 = d3 - d5
        val arrobject = arrayOf<Any>(d5)
        String.format("%.3f", *arrobject)
        val arrobject2 = arrayOf<Any>(d6)
        String.format("%.3f", *arrobject2)
        val n = d.toInt()
        if (n <= 100 && n >= 0) {
            val n2 = d2.toInt()
            if (n2 <= 100 && n2 >= 0) {
                val d7 = d5 * arrd[n]
                val d8 = d3 * arrd[n2] - d7
                val arrobject3 = arrayOf<Any>(d4)
                val string5 = String.format("%.3f", *arrobject3)
                val arrobject4 = arrayOf<Any>(d8)
                val string6 = String.format("%.3f", *arrobject4)
                Log.d("xS", string5)
                Log.d("xV", string6)
                sem_result!!.text = string5
                sem_result2!!.text = string6
            }
        }
        spirt_full!!.requestFocus()
        spirt_full!!.selectAll()
    }
}
