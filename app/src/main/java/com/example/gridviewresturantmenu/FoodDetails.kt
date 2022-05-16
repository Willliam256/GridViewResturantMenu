package com.example.gridviewresturantmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gridviewresturantmenu.databinding.ActivityFoodDetailsBinding

class FoodDetails : AppCompatActivity() {
    private lateinit var binding: ActivityFoodDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //collection the extra data from the previous Activity(MainActivity)
        binding.itemName.text = intent.getStringExtra("itemName")
        binding.itemDesc.text = intent.getStringExtra("itemDescription")
        binding.itemImage.setImageResource(intent.getIntExtra("itemImage", R.drawable.coffee_pot))

    }
}