package com.example.food_for_thought

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.food_for_thought.databinding.ActivityCheckStatusBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class CheckStatus : AppCompatActivity() {

    private lateinit var binding: ActivityCheckStatusBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var stat: Check

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckStatusBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView10.setOnClickListener {
            val intent = Intent(this, UserHome::class.java)
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            Toast.makeText(applicationContext,"Query!!!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, QueryStatus::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()

        getStatData()
    }

    private fun getStatData() {

        databaseReference = FirebaseDatabase.getInstance().getReference("Status")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for(feedSnap in snapshot.children) {
                        stat = feedSnap.getValue(Check::class.java)!!
                        binding.Checkr.text = stat.stat
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }
}