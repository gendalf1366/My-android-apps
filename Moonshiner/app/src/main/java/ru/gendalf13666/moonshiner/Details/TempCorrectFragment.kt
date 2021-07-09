package ru.gendalf13666.moonshiner.Details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R

class TempCorrectFragment : Fragment() {

    private var raschet: Button? = null
    private var sem_areom: EditText? = null
    private var sem_result: TextView? = null
    private var sem_temp: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_temp_correct, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        raschet = getView()?.findViewById(R.id.raschet)
        sem_temp = getView()?.findViewById(R.id.sem_temp)
        sem_areom = getView()?.findViewById(R.id.sem_areom)
        sem_result = getView()?.findViewById(R.id.sem_result)
        raschet!!.setOnClickListener { raschet_correct() }
    }

    fun raschet_correct() {
        val string2 = sem_temp!!.text.toString()
        val string3 = sem_areom!!.text.toString()
        val d = string2.toDouble()
        val d2 = string3.toDouble() + 0.3 * (20.0 - d)
        val textView = sem_result
        val arrobject = arrayOf<Any>(d2)
        @SuppressLint("DefaultLocale") val stringBuilder = String.format("%.2f", *arrobject) +
            "%"
        textView!!.text = stringBuilder
    }
}
