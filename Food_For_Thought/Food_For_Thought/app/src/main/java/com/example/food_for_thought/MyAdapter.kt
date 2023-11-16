package com.example.food_for_thought

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter (private val complist:ArrayList<Complaints>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    private lateinit var cListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }


    fun setOnItemClickListener(clickListener: OnItemClickListener){
        cListener= clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listcomplaints, parent, false)

        return ViewHolder(itemView, cListener)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentComp = complist[position]
        holder.tvCompName.text = currentComp.CName
    }

    override fun getItemCount(): Int {
        return complist.size
    }

    class ViewHolder(itemView: View, clickListener: OnItemClickListener ): RecyclerView.ViewHolder(itemView){
    val tvCompName : TextView = itemView.findViewById(R.id.tvName)


        init {
            itemView.setOnClickListener{

                clickListener.onItemClick(adapterPosition)
            }
        }
    }


}