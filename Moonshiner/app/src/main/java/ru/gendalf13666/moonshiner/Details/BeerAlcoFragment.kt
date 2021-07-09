package ru.gendalf13666.moonshiner.Details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R
import kotlin.math.pow

class BeerAlcoFragment : Fragment() {

    private var convert: CheckBox? = null
    private var pKoef: EditText? = null
    private var pKon: EditText? = null
    private var pNach: EditText? = null
    private var refract: CheckBox? = null
    private var rezultat: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beer_alco, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var button: Button
        this.pNach = getView()?.findViewById(R.id.pNach)
        this.pKon = getView()?.findViewById(R.id.pKon)
        this.pKoef = getView()?.findViewById(R.id.koefsuslo)
        this.rezultat = getView()?.findViewById(R.id.rezultat)
        this.convert = getView()?.findViewById(R.id.convert)
        this.refract = getView()?.findViewById(R.id.refract)
        button = getView()?.findViewById<Button>(R.id.button).also {
            if (it != null) {
                button = it
            }
        }!!
        button.setOnClickListener { raschet() }
    }

    private fun raschet() {
        val d: Double
        var d2: Double
        val string2: String = pNach?.text.toString()
        val string3: String = pKon?.text.toString()
        var string4: String = pKoef?.text.toString()
        var d3 = string2.toDouble()
        var d4 = string3.toDouble()
        if (string4.isEmpty()) {
            string4 = "1.0"
        }
        val d5 = string4.toDouble()
        if (d3 - d4 >= 1.0) {
            convert?.isChecked = true
        }
        if (d3 - d4 < 0.9999) {
            convert?.isChecked = false
        }
        if (convert?.isChecked ?: !refract?.isChecked!!) {
            d3 = 1.0 + d3 / (258.6 - 227.1 * (d3 / 258.2))
            d4 = 1.0 + d4 / (258.6 - 227.1 * (d4 / 258.2))
        }
        if (refract?.isChecked == true) {
            val d6 = 1.0 - 0.0044993 * (d3 / d5) + 0.0117741 * (d4 / d5) + 2.75806E-4 * (d3 / d5).pow(
                2.0
            ) - 0.00127169 * (d4 / d5).pow(2.0) - 7.27999E-6 * (d3 / d5).pow(3.0) + 6.32929E-5 * (d4 / d5).pow(3.0)
            d =
                100.0 * (
                0.01220703125 * (
                    d3 / d5 - (
                        0.1808 * (d3 / d5) + 0.8192 * (
                            668.72 * d6 - 463.37 - 205.347 * d6.pow(2.0)
                            )
                        )
                    ) / (2.0665 - 0.010665 * (d3 / d5))
                )
            java.lang.Double.valueOf(
                0.01220703125 * (
                    d3 / d5 - (
                        0.1808 * (d3 / d5) + 0.8192 * (
                            -463.37 - 205.347 * Math.pow(
                                0.0,
                                2.0
                            )
                            )
                        )
                    ) / (2.0665 - 0.010665 * (d3 / d5))
            )
            d2 = 0.0
        } else {
            val d7 = 131.25 * (d3 - d4)
            d2 = 76.8 * (d3 - d4) / (1.775 - d3) * (d4 / 0.794)
            d = d7
        }
        val textView: TextView? = rezultat
        val stringBuilder = String.format("%.2f", d) +
            "%"
        if (textView != null) {
            textView.text = stringBuilder
        }
    }
}
