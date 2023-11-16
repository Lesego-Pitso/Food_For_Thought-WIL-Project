package com.example.food_for_thought

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.food_for_thought.databinding.ActivityViewComplaintBinding
import com.google.firebase.database.*

class ViewComplaint : AppCompatActivity() {

    private lateinit var binding: ActivityViewComplaintBinding
    private lateinit var compRecyclerView: RecyclerView
    private lateinit var tvLoadingData: TextView
    private lateinit var complist: ArrayList<Complaints>
    private lateinit var  databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewComplaintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView16.setOnClickListener {
            val intent = Intent(this, AdminHome::class.java)
            startActivity(intent)
        }


        compRecyclerView = findViewById(R.id.Com)
        compRecyclerView.layoutManager = LinearLayoutManager(this)
        compRecyclerView.setHasFixedSize(true)
        tvLoadingData = findViewById(R.id.LoadingData)


        complist = arrayListOf()

        getComplaintData()


    }

    private fun getComplaintData() {
        compRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        databaseReference = FirebaseDatabase.getInstance().getReference("Complaints")

        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                complist.clear()
                if (snapshot.exists()){
                    for(compSnap in snapshot.children){
                        val compData = compSnap.getValue(Complaints::class.java)
                        complist.add(compData!!)
                    }
                    val adapter = MyAdapter( complist)
                    compRecyclerView.adapter = adapter

                  adapter.setOnItemClickListener(object :MyAdapter.OnItemClickListener{
                      override fun onItemClick(position: Int) {
                        val intent =   Intent(this@ViewComplaint, ComplaintDetails::class.java)


                          //put Extras
                          intent.putExtra("CompDate",complist[position].Date)
                          intent.putExtra("CompName",complist[position].CName)
                          intent.putExtra("Email",complist[position].CEmail)
                          intent.putExtra("Complain",complist[position].About)
                          intent.putExtra("CompDetails",complist[position].CDetail)

                          startActivity(intent)
                      }


                  })

                    compRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }
}