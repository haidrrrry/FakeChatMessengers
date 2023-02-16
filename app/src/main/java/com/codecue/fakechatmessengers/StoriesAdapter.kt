package com.codecue.fakechatmessengers

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codecue.fakechatmessengers.Chat
import com.codecue.fakechatmessengers.DbBitmapUtility
import com.codecue.fakechatmessengers.R
import com.codecue.fakechatmessengers.activities.ChatListActivity

class StoriesAdapter (val context: ChatListActivity) : RecyclerView.Adapter<StoriesAdapter.StoriesViewHolder>() {

    private var chatList = ArrayList<Chat>()

     class StoriesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

         val profileImage : ImageView = itemView.findViewById(R.id.profileImage)
         val tvName : TextView = itemView.findViewById(R.id.nameTV)

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.stories_item_view,
            parent,
            false)
        return StoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {

        val currentItem : Chat = chatList[position]

        val bm : Bitmap = DbBitmapUtility.getImage(currentItem.image)
        holder.profileImage.setImageBitmap(bm)
        holder.tvName.text = currentItem.Name

    }

    override fun getItemCount(): Int {

        return chatList.size
    }

    fun addItems(items : ArrayList<Chat>){
        this.chatList = items
        notifyDataSetChanged()
    }
}