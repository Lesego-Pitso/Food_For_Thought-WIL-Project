package com.example.food_for_thought

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.food_for_thought.databinding.ActivityComplaintDetailsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ComplaintDetails : AppCompatActivity() {

    private lateinit var binding: ActivityComplaintDetailsBinding
    private lateinit var tvComDate: TextView
    private lateinit var tvCompName: TextView
    private lateinit var tvCompEmail: TextView
    private lateinit var tvComplaint: TextView
    private lateinit var tvCompDetails: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComplaintDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView10.setOnClickListener {

            val intent = Intent(this, ViewComplaint::class.java)
            startActivity(intent)
        }

        initView()
        setValuesToViews()


        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Status")

        binding.button.setOnClickListener {

            val status = binding.Stat.text.toString()

            val sta = Check(status)


            if (uid != null) {

                databaseReference.child(uid).setValue(sta).addOnCompleteListener {

                    if (it.isSuccessful) {

                        Toast.makeText(this@ComplaintDetails, "Status Submitted", Toast.LENGTH_LONG)
                            .show()
                        val intent = Intent(this, AdminHome::class.java)
                        startActivity(intent)
                    } else {

                        Toast.makeText(
                            this@ComplaintDetails,
                            "Failed to submit feedback",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                }
            }

        }
    }

    private fun initView() {
        tvComDate = findViewById(R.id.tvComDate)
        tvCompName = findViewById(R.id.tvCompName)
        tvCompEmail = findViewById(R.id.tvCompEmail)
        tvComplaint = findViewById(R.id.tvComplaint)
        tvCompDetails = findViewById(R.id.tvCompDetails)

    }

    private fun setValuesToViews(){


        tvComDate.text = intent.getStringExtra("CompDate")
        tvCompName.text = intent.getStringExtra("CompName")
        tvCompEmail.text = intent.getStringExtra("Email")
        tvComplaint.text = intent.getStringExtra("Complain")
        tvCompDetails.text = intent.getStringExtra("CompDetails")
    }
}