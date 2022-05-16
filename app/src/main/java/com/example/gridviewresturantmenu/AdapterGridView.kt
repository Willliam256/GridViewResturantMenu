package com.example.gridviewresturantmenu

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdapterGridView(private val context: Context, private val arrayList: ArrayList<FoodData>):BaseAdapter() {

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position.toLong()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(positon: Int, view: View?, viewGroup: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val layoutView = inflater.inflate(R.layout.food_ticket, viewGroup, false)
        //accessing the name and image from the food ticket
        layoutView.findViewById<TextView>(R.id.item_name).text = arrayList[positon].name
        layoutView.findViewById<ImageView>(R.id.item_image).setImageResource(arrayList[positon].image)

        return layoutView
    }


}