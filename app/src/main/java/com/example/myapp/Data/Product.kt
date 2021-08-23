package com.example.myapp.Data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.myapp.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val text: String,
    @DrawableRes val image: Int
) : Parcelable {
}
