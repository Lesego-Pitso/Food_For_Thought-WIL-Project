package com.example.food_for_thought

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.food_for_thought.databinding.ActivityUserHomeBinding

class UserHome : AppCompatActivity() {

    private lateinit var binding: ActivityUserHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ComplaintButton.setOnClickListener {
            val intent = Intent(this, LogComplaint::class.java)
            startActivity(intent)
        }
        binding.FeedBackButton.setOnClickListener {
            val intent = Intent(this, ReceiveFeedback::class.java)
            startActivity(intent)
        }
        binding.CheckButton.setOnClickListener {
            val intent = Intent(this, CheckStatus::class.java)
            startActivity(intent)
        }
        binding.HireButton.setOnClickListener {
            val intent = Intent(this, RestaurantHiring::class.java)
            startActivity(intent)
        }
        binding.imageView11.setOnClickListener {
            val intent = Intent(this, UserHome::class.java)
            startActivity(intent)
        }

        binding.imageView12.setOnClickListener {
            Toast.makeText(applicationContext,"You have Logged Out", Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.imageView13.setOnClickListener {
            val intent = Intent(this, UpdateProfile::class.java)
            startActivity(intent)
        }
        binding.WebButton.setOnClickListener {
            "https://wilprojectv220231112182244.azurewebsites.net".openUrl()
        }


    }

    private fun String.openUrl() {

        val uri = Uri.parse(this)
        val intent = Intent(Intent.ACTION_VIEW, uri)

        startActivity(intent)
    }
}