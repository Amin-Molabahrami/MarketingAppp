package com.example.myapp.Data.Repository

import com.example.myapp.Data.Product
import com.example.myapp.R

object Data{
    fun loadData():List<Product>{
        return listOf(
            Product("Clothe1", R.drawable.lebas1),
            Product("Clothe2", R.drawable.lebas2),
            Product("Clothe3", R.drawable.lebas3),
            Product("Clothe4", R.drawable.lebas4),
            Product("Clothe5", R.drawable.lebas5),
            Product("Clothe6", R.drawable.lebas6),
            Product("Phone1", R.drawable.phone1),
            Product("Phone2", R.drawable.phone2),
            Product("Phone3", R.drawable.phone3),
            Product("Phone4", R.drawable.phone4),
            Product("Refrigerator1", R.drawable.yakhchal1),
            Product("Refrigerator2", R.drawable.yakhchal2),
            Product("Refrigerator3", R.drawable.yakhchal3),
        )
    }
}