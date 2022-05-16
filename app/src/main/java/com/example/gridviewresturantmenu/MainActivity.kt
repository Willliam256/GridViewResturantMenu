package com.example.gridviewresturantmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gridviewresturantmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    lateinit var name:Array<String>
    lateinit var description:Array<String>
    lateinit var image:Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting up the data source
        image = arrayOf(R.drawable.coffee_pot, R.drawable.french_fries, R.drawable.honey)
        name = arrayOf("Coffee", "French Fries", "Honey")
        description = arrayOf("coffee, beverage brewed from the roasted and ground seeds of the tropical evergreen coffee plants of African origin.",
            " French fries is one of the three most popular beverages in the world (alongside water and tea) and one of the most profitable international commodities.",
            "Honey, beverage brewed from the roasted and ground seeds of the tropical evergreen coffee plants of African origin.")

        val gridView = binding.gridview

        val listOfArray:ArrayList<FoodData> = ArrayList()

        //the loop below iterates through the arrays and adds the corresponding data from the data source
        //to the ArrayList using class FoodData
        for (i in name.indices){
            val rowItem = FoodData(name[i], image[i])
            listOfArray.add(rowItem)
        }

        //Connecting the grid_view to the Adapter through the GridView id
        gridView.adapter = AdapterGridView(this, listOfArray)

        //setting up an on_Item_Click_Listener to navigate the GridView item into another Activity using the GridView id
        gridView.isClickable = true
        gridView.setOnItemClickListener{parent, view, position, id ->

            val intent = Intent(this, FoodDetails::class.java)
            //Adding extra information/data required to be added in the next activity from "this Activity"
            // in the next activity(FoodDetails) from the above data source
            intent.putExtra("itemName", name[position])
            intent.putExtra("itemDescription", description[position])
            intent.putExtra("itemImage", image[position])
            startActivity(intent)
        }

    }

}