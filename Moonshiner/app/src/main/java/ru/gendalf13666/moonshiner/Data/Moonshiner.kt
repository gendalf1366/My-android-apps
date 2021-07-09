package ru.gendalf13666.moonshiner.Data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Moonshiner(
    val calc: String
) : Parcelable
