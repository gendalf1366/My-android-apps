package ru.gendalf13666.moonshiner.Main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ru.gendalf13666.moonshiner.Data.Moonshiner
import ru.gendalf13666.moonshiner.Details.* // ktlint-disable no-wildcard-imports
import ru.gendalf13666.moonshiner.R

class MyAdapter(listArray: ArrayList<Moonshiner>, context: MainFragment) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var arrayMoonshiner = listArray
    private var contextM = context

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val RecyclerItemTextView = view.findViewById<TextView>(R.id.mainFragmentRecyclerItemTextView)!!

        fun bind(moonshiner: Moonshiner, context: MainFragment) {
            RecyclerItemTextView.text = moonshiner.calc
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_main_recycler_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Moonshiner = arrayMoonshiner[position]
        holder.bind(Moonshiner, contextM)
        holder.itemView.setOnClickListener { v ->
            when (position) {
                0 -> {
                    val activity = v!!.context as AppCompatActivity
                    val SugarBragaFragment = SugarBragaFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, SugarBragaFragment).addToBackStack(null).commit()
                }
                1 -> {
                    val activity = v!!.context as AppCompatActivity
                    val BeerSusloFragment = BeerSusloFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, BeerSusloFragment).addToBackStack(null).commit()
                }
                2 -> {
                    val activity = v!!.context as AppCompatActivity
                    val HeadbodyFragment = HeadbodyFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, HeadbodyFragment).addToBackStack(null).commit()
                }
                3 -> {
                    val activity = v!!.context as AppCompatActivity
                    val BoilingFragment = BoilingFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, BoilingFragment).addToBackStack(null).commit()
                }
                4 -> {
                    val activity = v!!.context as AppCompatActivity
                    val RazbavkaFragment = RazbavkaFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, RazbavkaFragment).addToBackStack(null).commit()
                }
                5 -> {
                    val activity = v!!.context as AppCompatActivity
                    val MassmixingFragment = MassmixingFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, MassmixingFragment).addToBackStack(null).commit()
                }
                6 -> {
                    val activity = v!!.context as AppCompatActivity
                    val NapitokFragment = NapitokFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, NapitokFragment).addToBackStack(null).commit()
                }
                7 -> {
                    val activity = v!!.context as AppCompatActivity
                    val SmeshivanieFragment = SmeshivanieFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, SmeshivanieFragment).addToBackStack(null).commit()
                }
                8 -> {
                    val activity = v!!.context as AppCompatActivity
                    val BeerBrixFragment = BeerBrixFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, BeerBrixFragment).addToBackStack(null).commit()
                }
                9 -> {
                    val activity = v!!.context as AppCompatActivity
                    val BeerAlcoFragment = BeerAlcoFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, BeerAlcoFragment).addToBackStack(null).commit()
                }
                10 -> {
                    val activity = v!!.context as AppCompatActivity
                    val TempCorrectFragment = TempCorrectFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, TempCorrectFragment).addToBackStack(null).commit()
                }
                11 -> {
                    val activity = v!!.context as AppCompatActivity
                    val BeerIBUFragment = BeerIBUFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, BeerIBUFragment).addToBackStack(null).commit()
                }
                12 -> {
                    val activity = v!!.context as AppCompatActivity
                    val TemperatureFragment = TemperatureFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, TemperatureFragment).addToBackStack(null).commit()
                }
                13 -> {
                    val activity = v!!.context as AppCompatActivity
                    val VineSugarFragment = VineSugarFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, VineSugarFragment).addToBackStack(null).commit()
                }
                14 -> {
                    val activity = v!!.context as AppCompatActivity
                    val SpeedotborFragment = SpeedotborFragment()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.res, SpeedotborFragment).addToBackStack(null).commit()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayMoonshiner.size
    }

    fun updateAdapter(listArray: List<Moonshiner>) {
        arrayMoonshiner.clear()
        arrayMoonshiner.addAll(listArray)
        notifyDataSetChanged()
    }
}
