package com.example.food_for_thought


import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.food_for_thought.databinding.ActivityQueryFeedbackBinding


class QueryFeedback : AppCompatActivity() {

    private lateinit var binding: ActivityQueryFeedbackBinding


    @SuppressLint("IntentReset")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQueryFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recipientEditText = findViewById<EditText>(R.id.Text9)
        val subjectEditText = findViewById<EditText>(R.id.text3)
        val messageEditText = findViewById<EditText>(R.id.text4)


        binding.button.setOnClickListener {


            val recipient = recipientEditText.text.toString().trim()
            val subject = subjectEditText.text.toString().trim()
            val message = messageEditText.text.toString().trim()

            Toast.makeText(applicationContext,"Query Submitted!!!", Toast.LENGTH_LONG).show()
            val intent = Intent(Intent.ACTION_SEND)


            intent.data = Uri.parse("mailto")
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)

            try{
                startActivity(Intent.createChooser(intent,"send Email"))
            }catch (e: Exception){

                Toast.makeText(this,e.message, Toast.LENGTH_LONG).show()
            }

        }

        binding.imageView10.setOnClickListener {
            val intent = Intent(this, UserHome::class.java)
            startActivity(intent)
        }
    }
}