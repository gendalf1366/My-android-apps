package ru.gendalf13666.moonshiner.Details

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Chronometer.OnChronometerTickListener
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R
import java.lang.Boolean.getBoolean

class SpeedotborFragment : Fragment() {

    private var chronometer: Chronometer? = null
    private var elapsedMillis: Long = 0
    private var fullvolume: EditText? = null
    private var sem_info: TextView? = null
    private var sem_info2: TextView? = null
    private var sem_result: TextView? = null
    private var sem_result2: TextView? = null
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private var speed_conv: Switch? = null
    private var start: Button? = null
    private var volume: EditText? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speedotbor, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var button: Button? = null
        var button2: Button? = null
        var button3: Button? = null
        chronometer = getView()?.findViewById(R.id.chronometer)
        volume = getView()?.findViewById(R.id.sem_volume)
        fullvolume = getView()?.findViewById(R.id.sem_fullvolume)
        sem_result = getView()?.findViewById(R.id.sem_result)
        sem_result2 = getView()?.findViewById(R.id.sem_result2)
        sem_info = getView()?.findViewById(R.id.sem_info)
        sem_info2 = getView()?.findViewById(R.id.sem_info2)
        speed_conv = getView()?.findViewById(R.id.speed_conv)
        speed_conv!!.isChecked = getBoolean("speedotbor_conv")
        if (speed_conv!!.isChecked) {
            sem_info!!.setText(R.string.final_speed_conv)
            sem_info2!!.setText(R.string.final_time_conv)
        }
        chronometer!!.onChronometerTickListener =
            OnChronometerTickListener { chronometer: Chronometer ->
                elapsedMillis =
                    SystemClock.elapsedRealtime() - chronometer.base
            }
        start = getView()?.findViewById<Button>(R.id.start).also {
            if (it != null) {
                button3 = it
            }
        }
        button3?.setOnClickListener {
            if (volume?.text.toString().isEmpty()) {
                volume?.requestFocus()
                return@setOnClickListener
            }
            chronometer!!.setTextColor(Color.parseColor("#00ff00"))
            chronometer!!.base = SystemClock.elapsedRealtime()
            chronometer!!.start()
        }
        val stop: Button? = getView()?.findViewById<Button>(R.id.stop).also {
            if (it != null) {
                button = it
            }
        }
        button?.setOnClickListener {
            chronometer!!.setTextColor(Color.parseColor("#0000ff" as String))
            chronometer!!.stop()
            val d: Double =
                volume?.text.toString().toDouble() / 1000.0
            val d2 = (elapsedMillis.toInt() / 1000).toDouble()
            java.lang.Double.isNaN(d2)
            val d3 = d2 / 60.0
            val d4: Float = d.toFloat()
            java.lang.Double.isNaN(d4.toDouble())
            var d5 = d4 / d3
            if (speed_conv!!.isChecked) {
                d5 *= 60.0
            }
            val textView: TextView? = sem_result
            val arrobject = arrayOf<Any>(d5)
            if (textView != null) {
                textView.text = String.format("%.3f", *arrobject)
            }
            if (fullvolume?.getText().toString().isNotEmpty()) {
                val d6: Double = sem_result?.text.toString()
                    .format("," as CharSequence, "." as CharSequence).toDouble()
                val d7: Double = 60.0 * (
                    fullvolume?.text.toString()
                        .toDouble() / 1000.0 / d6
                    )
                val d8 = (d7.toInt() / 60).toDouble()
                val d9 = d7 % 60.0
                var string2 = "" +
                    d8.toInt()
                var string3 = "" +
                    d9.toInt()
                if (string2.length == 1) {
                    string2 = "0" +
                        string2
                }
                if (string3.length == 1) {
                    string3 = "0" +
                        string3
                }
                val textView2: TextView? = sem_result2
                val stringBuilder5 = string2 +
                    ":" +
                    string3
                if (textView2 != null) {
                    textView2.text = stringBuilder5
                }
            }
        }
        val reset: Button? = getView()?.findViewById<Button>(R.id.reset).also {
            if (it != null) {
                button2 = it
            }
        }
        button2?.setOnClickListener {
            chronometer!!.setTextColor(Color.parseColor("#888888"))
            chronometer!!.base = SystemClock.elapsedRealtime()
            sem_result?.text = "000"
            sem_result2?.text = "00:00"
        }
        speed_conv!!.setOnCheckedChangeListener { _: CompoundButton?, _: Boolean ->
            sem_info?.setText(R.string.final_speed)
            sem_info2?.setText(R.string.final_time)
        }
    }
}
