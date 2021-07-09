package ru.gendalf13666.moonshiner.Details

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.gendalf13666.moonshiner.R

class BoilingFragment : Fragment() {

    private var cubespirtview: TextView? = null
    private var cubetempview: TextView? = null
    private var jetspirtview: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_boiling, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cubetempview = getView()?.findViewById(R.id.cubetempview)
        cubespirtview = getView()?.findViewById(R.id.cubespirtview)
        jetspirtview = getView()?.findViewById(R.id.jetspirtview)
        getView()?.findViewById<SeekBar?>(R.id.cubetemp)
            ?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar, n: Int, bl: Boolean) {
                    val n2 = n + 88
                    cubetempview?.text = n2.toString()
                    val n3 = n * 21
                    val n4 = 255 - n3
                    cubetempview?.setTextColor(Color.rgb(n3, n4, 0))
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {}

                @SuppressLint("SetTextI18n")
                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    when (cubetempview?.text.toString().toInt()) {
                        100 -> {
                            cubespirtview?.text = "0.0"
                            jetspirtview?.text = "0.0"
                            return
                        }
                        99 -> {
                            cubespirtview?.text = "1.2"
                            jetspirtview?.text = "10.8"
                            return
                        }
                        98 -> {
                            cubespirtview?.text = "2.5"
                            jetspirtview?.text = "20.7"
                            return
                        }
                        97 -> {
                            cubespirtview?.text = "3.9"
                            jetspirtview?.text = "29.5"
                        }
                        96 -> {
                            cubespirtview?.text = "5.3"
                            jetspirtview?.text = "36.8"
                            return
                        }
                        95 -> {
                            cubespirtview?.text = "6.9"
                            jetspirtview?.text = "43.6"
                            return
                        }
                        94 -> {
                            cubespirtview?.text = "8.5"
                            jetspirtview?.text = "49.0"
                            return
                        }
                        93 -> {
                            cubespirtview?.text = "10.2"
                            jetspirtview?.text = "53.6"
                            return
                        }
                        92 -> {
                            cubespirtview?.text = "12.2"
                            jetspirtview?.text = "57.9"
                            return
                        }
                        91 -> {
                            cubespirtview?.text = "14.3"
                            jetspirtview?.text = "61.3"
                            return
                        }
                        90 -> {
                            cubespirtview?.text = "16.5"
                            jetspirtview?.text = "64.1"
                            return
                        }
                        89 -> {
                            cubespirtview?.text = "19.1"
                            jetspirtview?.text = "66.7"
                            return
                        }
                        88 -> {}
                        else -> {
                            return
                        }
                    }
                    cubespirtview?.text = "21.9"
                    jetspirtview?.text = "68.9"
                }
            })
    }
}

