package ru.gendalf13666.moonshiner.Details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R

class BeerBrixFragment : Fragment() {

    private var brix: EditText? = null
    private var brix_rez1: TextView? = null
    private var brix_rez2: TextView? = null
    private var rash_brix: ImageButton? = null
    private var rash_udves: ImageButton? = null
    private var udves: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beer_brix, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var imageButton: ImageButton? = null
        var imageButton4: ImageButton? = null
        brix = getView()?.findViewById(R.id.brix)
        udves = getView()?.findViewById(R.id.udves)
        brix_rez1 = getView()?.findViewById(R.id.brix_rez1)
        brix_rez2 = getView()?.findViewById(R.id.brix_rez2)
        rash_brix = getView()?.findViewById<ImageButton>(R.id.rash_brix).also {
            if (it != null) {
                imageButton4 = it
            }
        }
        imageButton4?.setOnClickListener { raschet_brix() }
        rash_udves = getView()?.findViewById<ImageButton>(R.id.rash_udves).also {
            if (it != null) {
                imageButton = it
            }
        }
        imageButton?.setOnClickListener { raschet_udves() }
    }

    private fun raschet_brix() {
        val string2: String = this.brix?.text.toString()
        val d = string2.toDouble()
        val d2 = 1.0 + d / (258.6 - 227.1 * (d / 258.2))
        val arrobject = arrayOf<Any>(d2)
        @SuppressLint("DefaultLocale") val string3 = String.format("%.4f", *arrobject)
        val textView: TextView? = brix_rez1
        val stringBuilder = d.toString() +
            ""
        if (textView != null) {
            textView.text = stringBuilder
        }
        brix_rez2?.text = string3
    }

    @SuppressLint("WrongConstant", "ShowToast")
    private fun raschet_udves() {
        val string2: String = this.udves?.text.toString()
        val d = string2.toDouble()
        val d2 = d * (1262.7794 + d * (182.4601 * d - 775.6821)) - 669.5622
        val arrobject = arrayOf<Any>(d2)
        @SuppressLint("DefaultLocale") val string3 = String.format("%.1f", *arrobject)
        val textView: TextView? = brix_rez1
        val stringBuilder = d.toString() +
            ""
        if (textView != null) {
            textView.text = stringBuilder
        }
        brix_rez2?.text = string3
    }
}
