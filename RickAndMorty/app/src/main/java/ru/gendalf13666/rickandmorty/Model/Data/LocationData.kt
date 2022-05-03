package ru.gendalf13666.rickandmorty.Model.Data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LocationData(
    var name: String,
    var url: String
) : Parcelable
