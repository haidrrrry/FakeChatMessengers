package com.codecue.fakechatmessengers

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codecue.fakechatmessengers.activities.ChatListActivity
import com.codecue.fakechatmessengers.activities.ChatScreen



class ChatListAdapter (val context: ChatListActivity): RecyclerView.Adapter<ChatListAdapter.ViewHolder>() {

    private var chatList = ArrayList<Chat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.chats_items_view,
            parent,
            false)
        return ViewHolder(view)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem : Chat = chatList[position]

        val bm : Bitmap = DbBitmapUtility.getImage(currentItem.image)
        holder.profileImage.setImageBitmap(bm)
        holder.tvName.text = currentItem.Name
        holder.tvLastMsgTime.text = currentItem.createdAT.trimStart()
        holder.tvLastMsgTime.text = currentItem.createdAT.trimStart()

        holder.itemView.setOnClickListener {

            val intent = Intent(context, ChatScreen::class.java)
            intent.putExtra("idKey", currentItem.id)
            intent.putExtra("nameKey", currentItem.Name)
            context.startActivity(intent)
        }



    }

    override fun getItemCount(): Int {  return chatList.size  }


    fun addItems(items : ArrayList<Chat>){
        this.chatList = items
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val profileImage : ImageView = itemView.findViewById(R.id.profileImage)
        val tvName : TextView = itemView.findViewById(R.id.tvChatName)
        //val tvLastMessage : TextView = itemView.findViewById(R.id.tvLastMessage)
        val tvLastMsgTime : TextView = itemView.findViewById(R.id.tvTime)
        val imageSeen : ImageView = itemView.findViewById(R.id.imageSeen)
    }
}