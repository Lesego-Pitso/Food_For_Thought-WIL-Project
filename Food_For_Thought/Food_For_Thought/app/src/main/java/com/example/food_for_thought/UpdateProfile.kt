package com.example.food_for_thought

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.food_for_thought.databinding.ActivityUpdateProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class UpdateProfile : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)


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
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }


        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        binding.UpdateButton.setOnClickListener {


            val name = binding.Name.text.toString()
            val email = binding.Email.text.toString()
            val phoneNumber = binding.Phone.text.toString()
            val workPlace = binding.Work.text.toString()


            val user = User(name,email,phoneNumber,workPlace)

            if (uid != null){

                databaseReference.child(uid).setValue(user).addOnCompleteListener{

                    if(it.isSuccessful){

                        Toast.makeText(this@UpdateProfile,"Successfully updated profile", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, Profile::class.java)
                        startActivity(intent)
                    }else{

                        Toast.makeText(this@UpdateProfile,"Failed to update profile", Toast.LENGTH_LONG).show()

                    }
                }
            }

        }





    }
}