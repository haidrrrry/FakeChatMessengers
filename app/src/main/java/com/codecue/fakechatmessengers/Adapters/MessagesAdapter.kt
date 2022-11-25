package com.codecue.fakechatmessengers.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codecue.fakechatmessengers.R

class MessagesAdapter (mContext: Context) : RecyclerView.Adapter<MessagesAdapter.MyViewHolder>() {

    private val senderLayout = 0
    private val receiverLayout = 1

    override fun getItemViewType(position: Int): Int {

        return if(position %2 != 0){
            senderLayout
        }else{
            receiverLayout
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = if(viewType == senderLayout) {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.send_message_layout, parent, false)
        }else{
            LayoutInflater.from(parent.context)
                .inflate(R.layout.receive_messages_layout, parent, false)

        }
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


    }

    override fun getItemCount(): Int {
        return 10

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}