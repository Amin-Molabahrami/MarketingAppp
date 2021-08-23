package com.example.myapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.databinding.ActivityGoodsBinding

class GoodsActivity : AppCompatActivity() {
    lateinit var binding: ActivityGoodsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGoodsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text= intent?.extras?.getString("goods_text").toString()
        val image=intent?.extras?.getInt("goods_image")

        val actionbar=supportActionBar
        actionbar?.title ="${text}"
        actionbar?.setDisplayHomeAsUpEnabled(true)

        binding.textId.text=text
        if (image != null) {
            binding.imageItem.setImageResource(image)
        }

        binding.buttonItem.setOnClickListener {
            Toast.makeText(this,"Added to cart", Toast.LENGTH_LONG).show()
        }

    }
}