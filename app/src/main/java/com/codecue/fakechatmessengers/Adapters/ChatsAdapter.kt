package com.codecue.fakechatmessengers.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.codecue.fakechatmessengers.R
import com.codecue.fakechatmessengers.activities.FakeChatActivities.ChatListActivity
import com.codecue.fakechatmessengers.activities.FakeChatActivities.ChatScreen

class ChatsAdapter (private val context : ChatListActivity) : RecyclerView.Adapter<ChatsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.chats_items_view, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.setOnClickListener{

            context.startActivity(Intent(context, ChatScreen::class.java))
        }
    }

    override fun getItemCount(): Int {
        return 12
    }

    class MyViewHolder(itemView : View) : ViewHolder(itemView) {

    }
}


