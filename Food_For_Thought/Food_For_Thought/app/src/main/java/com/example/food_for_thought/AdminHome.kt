package com.example.food_for_thought

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.food_for_thought.databinding.ActivityAdminHomeBinding
import com.example.food_for_thought.databinding.ActivityUserHomeBinding

class AdminHome : AppCompatActivity() {

    private lateinit var binding: ActivityAdminHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.View.setOnClickListener {
            val intent = Intent(this, ViewComplaint::class.java)
            startActivity(intent)
        }
        binding.FeedBack.setOnClickListener {
            val intent = Intent(this, SendFeedback::class.java)
            startActivity(intent)
        }
        binding.imageView12.setOnClickListener {
            Toast.makeText(applicationContext,"You have Logged Out", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}