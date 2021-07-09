package ru.gendalf13666.moonshiner.Details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R

class TemperatureFragment : Fragment() {

    private var full1: EditText? = null
    private var full2: EditText? = null
    private var mix_itog: TextView? = null
    private var raschet: Button? = null
    private var temp1: EditText? = null
    private var temp2: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_temperature, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        raschet = getView()?.findViewById(R.id.raschet)
        full1 = getView()?.findViewById(R.id.full1)
        full2 = getView()?.findViewById(R.id.full2)
        temp1 = getView()?.findViewById(R.id.temp1)
        temp2 = getView()?.findViewById(R.id.temp2)
        mix_itog = getView()?.findViewById(R.id.mix_itog)
        raschet!!.setOnClickListener { raschet_mix() }
    }

    private fun raschet_mix() {
        val string2 = full1!!.text.toString()
        val string3 = temp1!!.text.toString()
        val string4 = full2!!.text.toString()
        val string5 = temp2!!.text.toString()
        val d = string3.toDouble()
        val d2 = string2.toDouble()
        val d3 = string5.toDouble()
        val d4 = string4.toDouble()
        val d5 = (d * d2 + d3 * d4) / (d2 + d4)
        val textView = mix_itog
        val arrobject = arrayOf<Any>(d5)
        textView!!.text = String.format("%.1f", *arrobject)
    }
}
