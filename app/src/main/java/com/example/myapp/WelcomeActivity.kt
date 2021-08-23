package com.example.myapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.Adapter.WelcomeAdapter
import com.example.myapp.Data.Product
import com.example.myapp.Data.Repository.Data
import com.example.myapp.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityWelcomeBinding
    val goodsname = listOf("All", "Clothes", "Refrigerator", "Mobile Phone")
    val goods = Data.loadData()
    val recyclerView: RecyclerView? = null
    var list = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, goodsname)
        binding.spinner.adapter = arrayAdapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val gridLayoutManager =
                    GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
                binding.recycleView.layoutManager = gridLayoutManager
                binding.recycleView.setHasFixedSize(true)
                if (p2 == 0) {
                    binding.recycleView.adapter = WelcomeAdapter(applicationContext, goods)
                } else if (p2 == 1) {
                    binding.recycleView.adapter =
                        WelcomeAdapter(applicationContext, goods.filter { it.text.startsWith("C") })
                } else if (p2 == 2) {
                    binding.recycleView.adapter =
                        WelcomeAdapter(applicationContext, goods.filter { it.text.startsWith("R") })
                } else if (p2 == 3) {
                    binding.recycleView.adapter =
                        WelcomeAdapter(applicationContext, goods.filter { it.text.startsWith("P") })
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val actionbar = supportActionBar
        actionbar?.title = "Welcome"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        /////
        list.add(Product("test", R.drawable.ic_launcher_foreground))

        /////
    }

    override fun onResume() {
        super.onResume()
        val productAddedToCart = intent.extras?.getParcelable<Product>("cartProduct")
        if (productAddedToCart != null) {
            list.add(productAddedToCart)
        }
    }

}