package com.example.food_for_thought

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.food_for_thought.databinding.ActivityLogComplaintBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LogComplaint : AppCompatActivity() {

    private lateinit var binding: ActivityLogComplaintBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogComplaintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            Toast.makeText(applicationContext,"Complaint Submitted", Toast.LENGTH_LONG).show()
            val intent = Intent(this, UserHome::class.java)
            startActivity(intent)
        }
        binding.imageView10.setOnClickListener {
            val intent = Intent(this, UserHome::class.java)
            startActivity(intent)
        }


        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Complaints")

        binding.button3.setOnClickListener {


            val date = binding.Date.text.toString()
            val name = binding.name.text.toString()
            val email = binding.emailText.text.toString()
            val complaintAbout = binding.Text4.text.toString()
            val cname = binding.textView5.text.toString()
            val complaintDetail = binding.text10.text.toString()


            val com = Complaints(date,name,email,complaintAbout,cname,complaintDetail)

            if (uid != null){

                databaseReference.child(uid).setValue(com).addOnCompleteListener{

                    if(it.isSuccessful){

                        Toast.makeText(this@LogComplaint,"Complaint Submitted", Toast.LENGTH_LONG).show()
                        val intent = Intent(this,UserHome::class.java)
                        startActivity(intent)
                    }else{

                        Toast.makeText(this@LogComplaint,"Failed to update profile", Toast.LENGTH_LONG).show()

                    }
                }
            }

        }

    }
}