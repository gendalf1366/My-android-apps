package ru.gendalf13666.moonshiner.Details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R

class SugarBragaFragment : Fragment() {

    var alcostrong = 0.0
    var raschet: Button? = null
    var semMixVolume: EditText? = null
    var semResult: TextView? = null
    var semResult2: TextView? = null
    var semSugar: EditText? = null
    var sugar = 0.0
    var watermix = 0.0
    var waterneed = 0.0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sugar_braga, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val button: Button
        semSugar = getView()?.findViewById(R.id.sem_sugar)
        semMixVolume = getView()?.findViewById(R.id.sem_mixvolume)
        semResult = getView()?.findViewById(R.id.sem_result)
        semResult2 = getView()?.findViewById(R.id.sem_result2)
        button = requireView().findViewById(R.id.raschet)
        raschet = button
        button.setOnClickListener { SugarBraga() }
    }

    @SuppressLint("ResourceType", "DefaultLocale")
    private fun SugarBraga() {
        val d: Double
        val d2: Double
        sugar = semSugar!!.text.toString().toDouble()
        d = semMixVolume!!.text.toString().toDouble()
        watermix = d
        val d3 = sugar
        d2 = 0.91875 * (0.64 * d3 / (d / 100.0))
        alcostrong = d2
        waterneed = d - d3 * 0.615
        val textView = semResult
        val arrobject = arrayOf<Any>(d2)
        textView!!.text = String.format("%.1f", *arrobject)
        val textView2 = semResult2
        val arrobject2 = arrayOf<Any>(waterneed)
        textView2!!.text = String.format("%.3f", *arrobject2)
    }
}
