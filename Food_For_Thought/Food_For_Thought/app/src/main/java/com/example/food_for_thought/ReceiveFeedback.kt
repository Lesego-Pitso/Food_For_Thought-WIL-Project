package com.example.food_for_thought

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.food_for_thought.databinding.ActivityReceiveFeedbackBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ReceiveFeedback : AppCompatActivity() {

    private lateinit var binding: ActivityReceiveFeedbackBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var fed: Feedback




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiveFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Toast.makeText(applicationContext,"Query", Toast.LENGTH_LONG).show()
            val intent = Intent(this, QueryFeedback::class.java)
            startActivity(intent)
        }
        binding.imageView10.setOnClickListener {
            val intent = Intent(this, UserHome::class.java)
            startActivity(intent)
        }

        auth = FirebaseAuth.getInstance()



            getFeedData()



    }

    private fun getFeedData() {

        databaseReference = FirebaseDatabase.getInstance().getReference("Feedback")
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for(feedSnap in snapshot.children) {
                        fed = feedSnap.getValue(Feedback::class.java)!!
                        binding.Feedbackr.text = fed.Feed
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }
}