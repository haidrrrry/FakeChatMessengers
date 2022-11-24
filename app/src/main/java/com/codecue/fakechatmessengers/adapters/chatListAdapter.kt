package com.codecue.fakechatmessengers.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codecue.fakechatmessengers.R
import com.codecue.fakechatmessengers.activities.FakeChatActivities.ChatListActivity

class chatListAdapter(var context: ChatListActivity): RecyclerView.Adapter<chatListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_people_list,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        holder.itemView.setOnClickListener {
//
////            context.startActivity(Intent(context,ViewClassifiedVehicleActivity::class.java))
//            context.startActivity(Intent(context,ViewClassifiedVehicleActivity::class.java))
//        }

    }

    override fun getItemCount(): Int {
        return 7

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}