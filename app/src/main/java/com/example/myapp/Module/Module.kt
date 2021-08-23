package com.example.myapp.Module

import androidx.annotation.DrawableRes
import com.example.myapp.R

data class Module(val text:String, @DrawableRes val image:Int) {
}
object Data{
    fun loadData():List<Module>{
        return listOf(
            Module("Clothe1", R.drawable.lebas1),
            Module("Clothe2", R.drawable.lebas2),
            Module("Clothe3", R.drawable.lebas3),
            Module("Clothe4", R.drawable.lebas4),
            Module("Clothe5", R.drawable.lebas5),
            Module("Clothe6", R.drawable.lebas6),
            Module("Phone1", R.drawable.phone1),
            Module("Phone2", R.drawable.phone2),
            Module("Phone3", R.drawable.phone3),
            Module("Phone4", R.drawable.phone4),
            Module("Refrigerator1", R.drawable.yakhchal1),
            Module("Refrigerator2", R.drawable.yakhchal2),
            Module("Refrigerator3", R.drawable.yakhchal3),
        )
    }
}