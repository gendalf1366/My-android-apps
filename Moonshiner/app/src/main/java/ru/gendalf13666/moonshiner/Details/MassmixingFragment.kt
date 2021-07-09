package ru.gendalf13666.moonshiner.Details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R

class MassmixingFragment : Fragment() {

    private var button: Button? = null
    private var sem_result: TextView? = null
    private var spirt_full: EditText? = null
    private var spirt_itog: EditText? = null
    private var start_mass: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_massmixing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        start_mass = getView()?.findViewById(R.id.start_mass)
        spirt_full = getView()?.findViewById(R.id.spirt_full)
        spirt_itog = getView()?.findViewById(R.id.spirt_itog)
        sem_result = getView()?.findViewById(R.id.sem_result)
        button = getView()?.findViewById(R.id.button)
        button!!.setOnClickListener { raschet() }
    }

    private fun raschet() {
        val string2 = start_mass!!.text.toString()
        val string3 = spirt_full!!.text.toString()
        val string4 = spirt_itog!!.text.toString()
        val n = string2.toInt()
        val n2 = string3.toInt()
        if (n2 in 0..100) {
            val n3 = string4.toInt()
            if (n3 in 1..n2) {
                val arrarrd = arrayOf(
                    doubleArrayOf(0.9982),
                    doubleArrayOf(0.9967),
                    doubleArrayOf(0.9953),
                    doubleArrayOf(0.9938),
                    doubleArrayOf(0.9924),
                    doubleArrayOf(0.991),
                    doubleArrayOf(0.9897),
                    doubleArrayOf(0.9884),
                    doubleArrayOf(0.9872),
                    doubleArrayOf(0.9859),
                    doubleArrayOf(0.9847),
                    doubleArrayOf(0.9836),
                    doubleArrayOf(0.9824),
                    doubleArrayOf(0.9812),
                    doubleArrayOf(0.98),
                    doubleArrayOf(0.9789),
                    doubleArrayOf(0.9778),
                    doubleArrayOf(0.9768),
                    doubleArrayOf(0.9759),
                    doubleArrayOf(0.9746),
                    doubleArrayOf(0.9736),
                    doubleArrayOf(0.9725),
                    doubleArrayOf(0.9714),
                    doubleArrayOf(0.9703),
                    doubleArrayOf(0.9692),
                    doubleArrayOf(0.9681),
                    doubleArrayOf(0.967),
                    doubleArrayOf(0.9658),
                    doubleArrayOf(0.9646),
                    doubleArrayOf(0.9634),
                    doubleArrayOf(0.9622),
                    doubleArrayOf(0.961),
                    doubleArrayOf(0.9597),
                    doubleArrayOf(0.9584),
                    doubleArrayOf(0.957),
                    doubleArrayOf(0.9556),
                    doubleArrayOf(0.9542),
                    doubleArrayOf(0.9527),
                    doubleArrayOf(0.9512),
                    doubleArrayOf(0.9496),
                    doubleArrayOf(0.948),
                    doubleArrayOf(0.9464),
                    doubleArrayOf(0.9448),
                    doubleArrayOf(0.9431),
                    doubleArrayOf(0.9413),
                    doubleArrayOf(0.9395),
                    doubleArrayOf(0.9377),
                    doubleArrayOf(0.9359),
                    doubleArrayOf(0.934),
                    doubleArrayOf(0.9321),
                    doubleArrayOf(0.9302),
                    doubleArrayOf(0.9282),
                    doubleArrayOf(0.9262),
                    doubleArrayOf(0.9242),
                    doubleArrayOf(0.9221),
                    doubleArrayOf(0.92),
                    doubleArrayOf(0.9179),
                    doubleArrayOf(0.9157),
                    doubleArrayOf(0.9136),
                    doubleArrayOf(0.9114),
                    doubleArrayOf(0.9091),
                    doubleArrayOf(0.9069),
                    doubleArrayOf(0.9046),
                    doubleArrayOf(0.9023),
                    doubleArrayOf(0.9),
                    doubleArrayOf(0.8976),
                    doubleArrayOf(0.8952),
                    doubleArrayOf(0.8928),
                    doubleArrayOf(0.8904),
                    doubleArrayOf(0.888),
                    doubleArrayOf(0.8855),
                    doubleArrayOf(0.883),
                    doubleArrayOf(0.8805),
                    doubleArrayOf(0.8779),
                    doubleArrayOf(0.8754),
                    doubleArrayOf(0.8728),
                    doubleArrayOf(0.8701),
                    doubleArrayOf(0.8675),
                    doubleArrayOf(0.8648),
                    doubleArrayOf(0.862),
                    doubleArrayOf(0.8593),
                    doubleArrayOf(0.8565),
                    doubleArrayOf(0.8537),
                    doubleArrayOf(0.8508),
                    doubleArrayOf(0.8479),
                    doubleArrayOf(0.8449),
                    doubleArrayOf(0.8419),
                    doubleArrayOf(0.8389),
                    doubleArrayOf(0.8357),
                    doubleArrayOf(0.8325),
                    doubleArrayOf(0.8292),
                    doubleArrayOf(0.8259),
                    doubleArrayOf(0.8224),
                    doubleArrayOf(0.8189),
                    doubleArrayOf(0.8152),
                    doubleArrayOf(0.8114),
                    doubleArrayOf(0.8075),
                    doubleArrayOf(0.8033),
                    doubleArrayOf(0.799),
                    doubleArrayOf(0.7942),
                    doubleArrayOf(0.7892)
                )
                val d2 = arrarrd[n2][0]
                java.lang.Double.isNaN(n.toDouble())
                val d3 = n.toDouble() / d2
                val d4 = d3 / (n3.toDouble() / n2.toDouble()) - d3
                val textView = sem_result
                val arrobject = arrayOf<Any>(d4)
                textView!!.text = String.format("%.0f", *arrobject)
                return
            }
            spirt_full!!.requestFocus()
        }
    }
}
