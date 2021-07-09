package ru.gendalf13666.moonshiner.Details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R

class BeerIBUFragment : Fragment() {

    private var alpha1: EditText? = null
    private var alpha2: EditText? = null
    private var alpha3: EditText? = null
    private var alpha4: EditText? = null
    private var alpha5: EditText? = null
    private var density: EditText? = null
    private var rezultat: TextView? = null
    private var timer1: Spinner? = null
    private var timer2: Spinner? = null
    private var timer3: Spinner? = null
    private var timer4: Spinner? = null
    private var timer5: Spinner? = null
    private var volume: EditText? = null
    private var weight1: EditText? = null
    private var weight2: EditText? = null
    private var weight3: EditText? = null
    private var weight4: EditText? = null
    private var weight5: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beer_ibu, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var button: Button
        density = getView()?.findViewById(R.id.density)
        volume = getView()?.findViewById(R.id.volume)
        weight1 = getView()?.findViewById(R.id.weight1)
        weight2 = getView()?.findViewById(R.id.weight2)
        weight3 = getView()?.findViewById(R.id.weight3)
        weight4 = getView()?.findViewById(R.id.weight4)
        weight5 = getView()?.findViewById(R.id.weight5)
        alpha1 = getView()?.findViewById(R.id.alpha1)
        alpha2 = getView()?.findViewById(R.id.alpha2)
        alpha3 = getView()?.findViewById(R.id.alpha3)
        alpha4 = getView()?.findViewById(R.id.alpha4)
        alpha5 = getView()?.findViewById(R.id.alpha5)
        timer1 = getView()?.findViewById(R.id.timer1)
        timer2 = getView()?.findViewById(R.id.timer2)
        timer3 = getView()?.findViewById(R.id.timer3)
        timer4 = getView()?.findViewById(R.id.timer4)
        timer5 = getView()?.findViewById(R.id.timer5)
        rezultat = getView()?.findViewById<TextView>(R.id.rezultat)
        button = getView()?.findViewById<Button>(R.id.button).also {
            if (it != null) {
                button = it
            }
        }!!
        button.setOnClickListener { raschet_ibu() }
    }

    private fun raschet_ibu() {
        var d: Double
        var d2 = 0.0
        java.lang.Double.valueOf(0.0)
        val string2 = density!!.text.toString()
        val string3 = volume!!.text.toString()
        var d3 = string2.toDouble()
        val d4 = string3.toDouble()
        if (d3 > 1.1) {
            d3 = 1.0 + d3 / (258.6 - 227.1 * (d3 / 258.2))
        }
        val arrdouble = java.lang.reflect.Array.newInstance(
            Double::class.java, *intArrayOf(10, 5)
        ) as Array<Array<Double>>
        arrdouble[0][0] = 0.055
        arrdouble[0][1] = 0.05
        arrdouble[0][2] = 0.046
        arrdouble[0][3] = 0.042
        arrdouble[0][4] = 0.038
        arrdouble[1][0] = 0.1
        arrdouble[1][1] = 0.091
        arrdouble[1][2] = 0.084
        arrdouble[1][3] = 0.076
        arrdouble[1][4] = 0.07
        arrdouble[2][0] = 0.137
        arrdouble[2][1] = 0.125
        arrdouble[2][2] = 0.114
        arrdouble[2][3] = 0.105
        arrdouble[2][4] = 0.096
        arrdouble[3][0] = 0.167
        arrdouble[3][1] = 0.153
        arrdouble[3][2] = 0.14
        arrdouble[3][3] = 0.128
        arrdouble[3][4] = 0.117
        arrdouble[4][0] = 0.212
        arrdouble[4][1] = 0.194
        arrdouble[4][2] = 0.177
        arrdouble[4][3] = 0.162
        arrdouble[4][4] = 0.148
        arrdouble[5][0] = 0.242
        arrdouble[5][1] = 0.221
        arrdouble[5][2] = 0.202
        arrdouble[5][3] = 0.185
        arrdouble[5][4] = 0.169
        arrdouble[6][0] = 0.276
        arrdouble[6][1] = 0.252
        arrdouble[6][2] = 0.231
        arrdouble[6][3] = 0.211
        arrdouble[6][4] = 0.193
        arrdouble[7][0] = 0.291
        arrdouble[7][1] = 0.266
        arrdouble[7][2] = 0.243
        arrdouble[7][3] = 0.222
        arrdouble[7][4] = 0.203
        arrdouble[8][0] = 0.295
        arrdouble[8][1] = 0.27
        arrdouble[8][2] = 0.247
        arrdouble[8][3] = 0.226
        arrdouble[8][4] = 0.206
        arrdouble[9][0] = 0.301
        arrdouble[9][1] = 0.275
        arrdouble[9][2] = 0.252
        arrdouble[9][3] = 0.23
        arrdouble[9][4] = 0.21
        if (weight1!!.length() != 0) {
            val d5 = weight1!!.text.toString().toDouble()
            val d6 = alpha1!!.text.toString().toDouble()
            java.lang.Double.valueOf(timer1!!.selectedItem.toString().toDouble())
            val n = timer1!!.selectedItemPosition
            var d7 = if (d3 == 1.03) arrdouble[n][0] else d2
            if (d3 > 1.03 && d3 < 1.04) {
                d7 =
                    arrdouble[n][0] + (d3 - 1.03) / 0.01 * ((arrdouble[n][1] - arrdouble[n][0]) / 1.0)
            }
            if (d3 == 1.04) {
                d7 = arrdouble[n][1]
            }
            if (d3 > 1.04 && d3 < 1.05) {
                d7 =
                    arrdouble[n][1] + (d3 - 1.04) / 0.01 * ((arrdouble[n][1] - arrdouble[n][1]) / 1.0)
            }
            if (d3 == 1.05) {
                d7 = arrdouble[n][2]
            }
            if (d3 > 1.05 && d3 < 1.06) {
                d7 =
                    arrdouble[n][2] + (d3 - 1.04) / 0.01 * ((arrdouble[n][2] - arrdouble[n][2]) / 1.0)
            }
            if (d3 == 1.06) {
                d7 = arrdouble[n][3]
            }
            if (d3 > 1.06 && d3 < 1.07) {
                d7 =
                    arrdouble[n][3] + (d3 - 1.04) / 0.01 * ((arrdouble[n][3] - arrdouble[n][3]) / 1.0)
            }
            if (d3 == 1.07) {
                d7 = arrdouble[n][4]
            }
            if (d3 > 1.07) {
                d7 = 999.0
            }
            val d8 = d7 * (d5 * d6 / (0.1 * d4))
            d = d2 + d8
            d2 = d7
        } else {
            d = d2
        }
        if (weight2!!.length() != 0) {
            val d9 = weight2!!.text.toString().toDouble()
            val d10 = alpha2!!.text.toString().toDouble()
            java.lang.Double.valueOf(timer2!!.selectedItem.toString().toDouble())
            val n = timer2!!.selectedItemPosition
            if (d3 == 1.03) {
                d2 = arrdouble[n][0]
            }
            if (d3 > 1.03 && d3 < 1.04) {
                d2 =
                    arrdouble[n][0] + (d3 - 1.03) / 0.01 * ((arrdouble[n][1] - arrdouble[n][0]) / 1.0)
            }
            if (d3 == 1.04) {
                d2 = arrdouble[n][1]
            }
            if (d3 > 1.04 && d3 < 1.05) {
                d2 =
                    arrdouble[n][1] + (d3 - 1.04) / 0.01 * ((arrdouble[n][1] - arrdouble[n][1]) / 1.0)
            }
            if (d3 == 1.05) {
                d2 = arrdouble[n][2]
            }
            if (d3 > 1.05 && d3 < 1.06) {
                d2 =
                    arrdouble[n][2] + (d3 - 1.04) / 0.01 * ((arrdouble[n][2] - arrdouble[n][2]) / 1.0)
            }
            if (d3 == 1.06) {
                d2 = arrdouble[n][3]
            }
            if (d3 > 1.06 && d3 < 1.07) {
                d2 =
                    arrdouble[n][3] + (d3 - 1.04) / 0.01 * ((arrdouble[n][3] - arrdouble[n][3]) / 1.0)
            }
            if (d3 == 1.07) {
                d2 = arrdouble[n][4]
            }
            if (d3 > 1.07) {
                d2 = 999.0
            }
            val d11 = d2 * (d9 * d10 / (0.1 * d4))
            d = d + d11
        }
        if (weight3!!.length() != 0) {
            val d12 = weight3!!.text.toString().toDouble()
            val d13 = alpha3!!.text.toString().toDouble()
            java.lang.Double.valueOf(timer3!!.selectedItem.toString().toDouble())
            val n = timer3!!.selectedItemPosition
            if (d3 == 1.03) {
                d2 = arrdouble[n][0]
            }
            if (d3 > 1.03 && d3 < 1.04) {
                d2 =
                    arrdouble[n][0] + (d3 - 1.03) / 0.01 * ((arrdouble[n][1] - arrdouble[n][0]) / 1.0)
            }
            if (d3 == 1.04) {
                d2 = arrdouble[n][1]
            }
            if (d3 > 1.04 && d3 < 1.05) {
                d2 =
                    arrdouble[n][1] + (d3 - 1.04) / 0.01 * ((arrdouble[n][1] - arrdouble[n][1]) / 1.0)
            }
            if (d3 == 1.05) {
                d2 = arrdouble[n][2]
            }
            if (d3 > 1.05 && d3 < 1.06) {
                d2 =
                    arrdouble[n][2] + (d3 - 1.04) / 0.01 * ((arrdouble[n][2] - arrdouble[n][2]) / 1.0)
            }
            if (d3 == 1.06) {
                d2 = arrdouble[n][3]
            }
            if (d3 > 1.06 && d3 < 1.07) {
                d2 =
                    arrdouble[n][3] + (d3 - 1.04) / 0.01 * ((arrdouble[n][3] - arrdouble[n][3]) / 1.0)
            }
            if (d3 == 1.07) {
                d2 = arrdouble[n][4]
            }
            if (d3 > 1.07) {
                d2 = 999.0
            }
            val d14 = d2 * (d12 * d13 / (0.1 * d4))
            d = d + d14
        }
        if (weight4!!.length() != 0) {
            val d15 = weight4!!.text.toString().toDouble()
            val d16 = alpha4!!.text.toString().toDouble()
            java.lang.Double.valueOf(timer4!!.selectedItem.toString().toDouble())
            val n = timer4!!.selectedItemPosition
            if (d3 == 1.03) {
                d2 = arrdouble[n][0]
            }
            if (d3 > 1.03 && d3 < 1.04) {
                d2 =
                    arrdouble[n][0] + (d3 - 1.03) / 0.01 * ((arrdouble[n][1] - arrdouble[n][0]) / 1.0)
            }
            if (d3 == 1.04) {
                d2 = arrdouble[n][1]
            }
            if (d3 > 1.04 && d3 < 1.05) {
                d2 =
                    arrdouble[n][1] + (d3 - 1.04) / 0.01 * ((arrdouble[n][1] - arrdouble[n][1]) / 1.0)
            }
            if (d3 == 1.05) {
                d2 = arrdouble[n][2]
            }
            if (d3 > 1.05 && d3 < 1.06) {
                d2 =
                    arrdouble[n][2] + (d3 - 1.04) / 0.01 * ((arrdouble[n][2] - arrdouble[n][2]) / 1.0)
            }
            if (d3 == 1.06) {
                d2 = arrdouble[n][3]
            }
            if (d3 > 1.06 && d3 < 1.07) {
                d2 =
                    arrdouble[n][3] + (d3 - 1.04) / 0.01 * ((arrdouble[n][3] - arrdouble[n][3]) / 1.0)
            }
            if (d3 == 1.07) {
                d2 = arrdouble[n][4]
            }
            if (d3 > 1.07) {
                d2 = 999.0
            }
            val d17 = d2 * (d15 * d16 / (0.1 * d4))
            d = d + d17
        }
        if (weight5!!.length() != 0) {
            val d18 = weight5!!.text.toString().toDouble()
            val d19 = alpha5!!.text.toString().toDouble()
            java.lang.Double.valueOf(timer5!!.selectedItem.toString().toDouble())
            val n = timer5!!.selectedItemPosition
            if (d3 == 1.03) {
                d2 = arrdouble[n][0]
            }
            if (d3 > 1.03 && d3 < 1.04) {
                d2 =
                    arrdouble[n][0] + (d3 - 1.03) / 0.01 * ((arrdouble[n][1] - arrdouble[n][0]) / 1.0)
            }
            if (d3 == 1.04) {
                d2 = arrdouble[n][1]
            }
            if (d3 > 1.04 && d3 < 1.05) {
                d2 =
                    arrdouble[n][1] + (d3 - 1.04) / 0.01 * ((arrdouble[n][1] - arrdouble[n][1]) / 1.0)
            }
            if (d3 == 1.05) {
                d2 = arrdouble[n][2]
            }
            if (d3 > 1.05 && d3 < 1.06) {
                d2 =
                    arrdouble[n][2] + (d3 - 1.04) / 0.01 * ((arrdouble[n][2] - arrdouble[n][2]) / 1.0)
            }
            if (d3 == 1.06) {
                d2 = arrdouble[n][3]
            }
            if (d3 > 1.06 && d3 < 1.07) {
                d2 =
                    arrdouble[n][3] + (d3 - 1.04) / 0.01 * ((arrdouble[n][3] - arrdouble[n][3]) / 1.0)
            }
            if (d3 == 1.07) {
                d2 = arrdouble[n][4]
            }
            if (d3 > 1.07) {
                d2 = 999.0
            }
            val d20 = d2 * (d18 * d19 / (0.1 * d4))
            d = d + d20
        }
        rezultat!!.text = String.format("%.1f", d)
    }
}
