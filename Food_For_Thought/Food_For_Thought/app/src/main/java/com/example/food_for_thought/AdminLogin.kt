package com.example.food_for_thought

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.food_for_thought.databinding.ActivityAdminLoginBinding
import com.google.firebase.auth.FirebaseAuth

class AdminLogin : AppCompatActivity() {

    private lateinit var binding: ActivityAdminLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.adminButton2.setOnClickListener {

            val email = binding.username2.text.toString()
            val pass = binding.password2.text.toString()


            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(applicationContext,"You have Logged In", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, AdminHome::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed ! ", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}