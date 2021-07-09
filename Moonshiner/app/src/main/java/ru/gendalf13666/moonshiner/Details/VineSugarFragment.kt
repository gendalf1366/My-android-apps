package ru.gendalf13666.moonshiner.Details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R

class VineSugarFragment : Fragment() {

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private var strongtosugar: Switch? = null
    private var vinestrong_finish: EditText? = null
    private var vinesugar_full: TextView? = null
    private var vinesugar_need: TextView? = null
    private var vinesugar_start: EditText? = null
    private var vinesus_full: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vine_sugar, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var imageButton3: ImageButton? = null
        var button: Button
        vinesus_full = getView()?.findViewById(R.id.vinesus_full)
        vinesugar_start = getView()?.findViewById(R.id.vinesugar_start)
        vinestrong_finish = getView()?.findViewById(R.id.vinestrong_finish)
        vinesugar_need = getView()?.findViewById(R.id.vinesugar_need)
        vinesugar_full = getView()?.findViewById(R.id.vinesugar_full)
        strongtosugar = getView()?.findViewById(R.id.strongtosugar)
        button = getView()?.findViewById<Button>(R.id.button).also {
            if (it != null) {
                button = it
            }
        }!!
        button.setOnClickListener { vinesugar_raschet() }
        imageButton3?.setOnClickListener {
            vinestrong_finish?.text = null
            vinestrong_finish?.requestFocus()
        }
    }

    private fun vinesugar_raschet() {
        val string2 = vinesus_full!!.text.toString()
        val string3 = vinesugar_start!!.text.toString()
        val string4 = vinestrong_finish!!.text.toString()
        val d = string2.toDouble()
        val d2 = string3.toDouble()
        val d3 = string4.toDouble()
        if (strongtosugar!!.isChecked) {
            val d4 = (d3 * d - d * d2) / 100.0
            val textView = vinesugar_need
            val arrobject = arrayOf<Any>(d4)
            textView!!.text = String.format("%.3f", *arrobject)
            vinesugar_full!!.text = ""
        } else {
            val d5 = d3 * 1.7
            val d6 = d * (10.0 * (d5 - d2)) / 1000.0
            val textView = vinesugar_need
            val arrobject = arrayOf<Any>(d6)
            textView!!.text = String.format("%.3f", *arrobject)
            val textView2 = vinesugar_full
            val arrobject2 = arrayOf<Any>(d5)
            textView2!!.text = String.format("%.1f", *arrobject2)
        }
    }
}
