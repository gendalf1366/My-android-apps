package ru.gendalf13666.moonshiner.Details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R

class BeerSusloFragment : Fragment() {

    var extr = 0.0
    var extract: EditText? = null
    var nachplot: EditText? = null
    var plot = 0.0
    var raschet: Button? = null
    var rez = 0.0
    var rezult: TextView? = null
    var suslovol: EditText? = null
    var vol = 0.0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beer_suslo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        suslovol = getView()?.findViewById(R.id.suslovol)
        nachplot = getView()?.findViewById(R.id.nachplot)
        extract = getView()?.findViewById(R.id.extract)
        raschet = getView()?.findViewById(R.id.raschet)
        rezult = getView()?.findViewById(R.id.rezult)
        raschet?.setOnClickListener { beerSuslo() }
    }

    private fun beerSuslo() {
        val d: Double
        val d2: Double
        vol = suslovol?.getText().toString().replace(",", ".").toDouble()
        plot = nachplot?.getText().toString().replace(",", ".").toDouble()
        d = extract?.getText().toString().replace(",", ".").toDouble()
        extr = d
        d2 = vol * (plot / 100.0) / (d / 100.0)
        rez = d2
        val textView: TextView? = rezult
        val arrobject = arrayOf<Any>(d2)
        if (textView != null) {
            textView.text = String.format("%.3f", *arrobject)
        }
    }
}
