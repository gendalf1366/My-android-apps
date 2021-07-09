package ru.gendalf13666.moonshiner.Details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R

class SmeshivanieFragment : Fragment() {

    private var DP1 = 0.0
    private var DP2 = 0.0
    private var Vol1 = 0.0
    private var Vol2 = 0.0
    private var full1: EditText? = null
    private var full2: EditText? = null
    private var raschet: Button? = null
    private var spirt_itog: TextView? = null
    private var spirt_itog2: TextView? = null
    private var strong1: EditText? = null
    private var strong2: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_smeshivanie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var button: Button? = null
        raschet = getView()?.findViewById<Button>(R.id.raschet).also {
            if (it != null) {
                button = it
            }
        }
        button?.setOnClickListener { raschet_smeshivanie() }
        full1 = getView()?.findViewById(R.id.full1)
        full2 = getView()?.findViewById(R.id.full2)
        strong1 = getView()?.findViewById(R.id.strong1)
        strong2 = getView()?.findViewById(R.id.strong2)
        spirt_itog = getView()?.findViewById(R.id.spirt_itog)
        spirt_itog2 = getView()?.findViewById(R.id.spirt_itog2)
    }

    fun raschet_smeshivanie() {
        val string2 = full1!!.text.toString()
        val string3 = full2!!.text.toString()
        val string4 = strong1!!.text.toString()
        val string5 = strong2!!.text.toString()
        val d = string2.toDouble()
        val d2 = string3.toDouble()
        val d3 = string4.toDouble()
        val d4 = string5.toDouble()
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
        val arrd2 = doubleArrayOf(
            0.0,
            0.9967,
            0.49765,
            0.331266667,
            0.2481,
            0.1982,
            0.16495,
            0.1412,
            0.1234,
            0.109544444,
            0.09847,
            0.089418182,
            0.081866667,
            0.075476923,
            0.07,
            0.06526,
            0.0611125,
            0.057458824,
            0.054216667,
            0.051294737,
            0.04868,
            0.046309524,
            0.044154545,
            0.042186957,
            0.040383333,
            0.038724,
            0.037192308,
            0.03577037,
            0.03445,
            0.03322069,
            0.032073333,
            0.031,
            0.029990625,
            0.029042424,
            0.028147059,
            0.027302857,
            0.026505556,
            0.025748649,
            0.025031579,
            0.024348718,
            0.0237,
            0.023082927,
            0.022495238,
            0.021932558,
            0.021393182,
            0.020877778,
            0.020384783,
            0.019912766,
            0.019458333,
            0.019022449,
            0.018604,
            0.0182,
            0.017811538,
            0.017437736,
            0.017075926,
            0.016727273,
            0.016391071,
            0.016064912,
            0.015751724,
            0.015447458,
            0.015151667,
            0.014867213,
            0.014590323,
            0.014322222,
            0.0140625,
            0.013809231,
            0.013563636,
            0.013325373,
            0.013094118,
            0.012869565,
            0.01265,
            0.01243662,
            0.012229167,
            0.012026027,
            0.01182973,
            0.011637333,
            0.011448684,
            0.011266234,
            0.011087179,
            0.010911392,
            0.01074125,
            0.010574074,
            0.010410976,
            0.010250602,
            0.010094048,
            0.00994,
            0.009789535,
            0.009642529,
            0.009496591,
            0.009353933,
            0.009213333,
            0.009075824,
            0.00893913,
            0.008805376,
            0.00867234,
            0.008541053,
            0.008411458,
            0.008281443,
            0.008153061,
            0.008022222,
            0.007892
        )
        val d5 = d * d3 + d2 * d4
        val d6 = d + d2
        val d7 = d5 / d6
        val arrobject = arrayOf<Any>(d7)
        String.format("%.2f", *arrobject)
        val arrobject2 = arrayOf<Any>(d6)
        String.format("%.3f", *arrobject2)
        val n = d3.toInt()
        val n2 = d4.toInt()
        val d8 = arrd[n]
        val d9 = arrd[n2]
        val d10 = (d * d8 + d2 * d9) / d5
        for (i in 1..99) {
            var n3: Int? = null
            if (arrd2[i] <= d10 || arrd2[i + 1.also { n3 = it }] >= d10) continue
            DP1 = arrd2[i]
            DP2 = arrd2[n3!!]
            Vol1 = i.toDouble()
            Vol2 = n3!!.toDouble()
        }
        val d11 = DP2
        val d12 = DP1
        val d13 = d11 - d12
        val d14 = Vol2
        val d15 = Vol1
        val d16 = d15 + (d14 - d15) / d13 * (d10 - d12)
        val d17 = d5 / d16
        val arrobject3 = arrayOf<Any>(d16)
        val string6 = String.format("%.2f", *arrobject3)
        val arrobject4 = arrayOf<Any>(d17)
        val string7 = String.format("%.3f", *arrobject4)
        val textView = spirt_itog
        val stringBuilder = string6 +
            "%"
        textView!!.text = stringBuilder
        spirt_itog2!!.text = string7
    }
}
