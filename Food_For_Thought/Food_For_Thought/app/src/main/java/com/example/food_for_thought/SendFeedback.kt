package com.example.food_for_thought

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.food_for_thought.databinding.ActivitySendFeedbackBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SendFeedback : AppCompatActivity() {

    private lateinit var binding: ActivitySendFeedbackBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageView16.setOnClickListener {

            Toast.makeText(this@SendFeedback, "Back to home page", Toast.LENGTH_LONG)
                .show()
            val intent = Intent(this, AdminHome::class.java)
            startActivity(intent)

        }


        auth = FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Feedback")

        binding.button.setOnClickListener {

            val feed = binding.FeedBackText.text.toString()

            val fed = Feedback(feed)


            if (uid != null) {

                databaseReference.child(uid).setValue(fed).addOnCompleteListener {

                    if (it.isSuccessful) {

                        Toast.makeText(this@SendFeedback, "Feedback Submitted", Toast.LENGTH_LONG)
                            .show()
                        val intent = Intent(this, AdminHome::class.java)
                        startActivity(intent)
                    } else {

                        Toast.makeText(
                            this@SendFeedback,
                            "Failed to submit feedback",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                }
            }

        }
    }
}



