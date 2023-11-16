package com.example.food_for_thought

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.food_for_thought.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var user: User
    private lateinit var uid : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.UpdateButton.setOnClickListener {
            Toast.makeText(applicationContext,"Update Profile Info.", Toast.LENGTH_LONG).show()
            val intent = Intent(this, UpdateProfile::class.java)
            startActivity(intent)
        }
        binding.BackHome.setOnClickListener {
            val intent = Intent(this, UserHome::class.java)
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
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        binding.imageView10.setOnClickListener {
            val intent = Intent(this, UserHome::class.java)
            startActivity(intent)
        }


        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()

        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        if(uid.isNotEmpty()){

            getUserData()
        }


    }

    private fun getUserData() {

        databaseReference.child(uid).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                user = snapshot.getValue(User::class.java)!!
                binding.name.text = user.Name
                binding.email.text = user.Email
                binding.number.text = user.Number
                binding.work.text = user.Work
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }
}