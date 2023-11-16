package com.example.food_for_thought

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import android.widget.Toast
import com.example.food_for_thought.databinding.ActivityRestaurantHiringBinding

class RestaurantHiring : AppCompatActivity() {

    private lateinit var binding: ActivityRestaurantHiringBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurantHiringBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView10.setOnClickListener {
            val intent = Intent(this, UserHome::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            Toast.makeText(applicationContext,"Back to Home", Toast.LENGTH_LONG).show()
            val intent = Intent(this, UserHome::class.java)
            startActivity(intent)
        }

        val link1 : TextView = findViewById(R.id.textView8)
        val link2 : TextView = findViewById(R.id.textView12)
        val link3 : TextView = findViewById(R.id.textView17)


        link1.movementMethod = LinkMovementMethod.getInstance()
        link1.setLinkTextColor(Color.BLUE)

        link2.movementMethod = LinkMovementMethod.getInstance()
        link2.setLinkTextColor(Color.BLUE)

        link3.movementMethod = LinkMovementMethod.getInstance()
        link3.setLinkTextColor(Color.BLUE)
    }
}