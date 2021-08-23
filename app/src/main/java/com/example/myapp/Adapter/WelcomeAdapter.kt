package com.example.myapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.GoodsActivity
import com.example.myapp.Data.Product
import com.example.myapp.R

class WelcomeAdapter(var context: Context,val dataset:List<Product>): RecyclerView.Adapter<WelcomeAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder=LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ItemHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val data:Product=dataset.get(position)

        holder.imagebutton.setImageResource(data.image)
        holder.title.text=data.text

        holder.imagebutton.setOnClickListener {
            val intent = Intent(holder.itemView.context,GoodsActivity::class.java)
//            intent.putExtra("goods_text",data.text)
//            intent.putExtra("goods_image",data.image)

            //replaced with Parcelable
            intent.putExtra("selectedProduct",data)

            holder.itemView.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    class ItemHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imagebutton:ImageButton=itemView.findViewById<ImageButton>(R.id.icon_image)
        val title:TextView=itemView.findViewById(R.id.Title)
    }

}