package com.codecue.fakechatmessengers.activities

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore.Images.Media.insertImage
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codecue.fakechatmessengers.*
import com.codecue.fakechatmessengers.databinding.ActivityChatListBinding


class ChatListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatListBinding
    private lateinit var chatsRV: RecyclerView
    private lateinit var storiesRV: RecyclerView
    private lateinit var chatsAdapter: ChatListAdapter
    private lateinit var storiesAdapter: StoriesAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setImage()
        initRecyclerView()
        getAllChats()
        setOnClickListeners()

    }



    private fun setImage() {

        databaseHelper = DatabaseHelper(this)
        val c = databaseHelper.getImage()
        binding.circleImageView.setImageBitmap(c)
    }

    /** Get Chats And Update When New Chat is Added **/
    private fun getAllChats() {
        val chatList = databaseHelper.getAllChats()
        chatsAdapter.addItems(chatList)

        val storiesList = databaseHelper.getAllChats()
        storiesAdapter.addItems(chatList)
    }

    private fun initRecyclerView() {

        databaseHelper = DatabaseHelper(this)

        /** Chats RV **/

        chatsRV = binding.chatRecyclerView
        chatsAdapter = ChatListAdapter(this)
        chatsRV.adapter = chatsAdapter
        chatsRV.layoutManager = LinearLayoutManager(this)

        /** Stories RV **/

        storiesRV = binding.storiesRecyclerView
        storiesAdapter = StoriesAdapter(this)
        storiesRV.adapter = storiesAdapter
        storiesRV.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
    }

    private fun setOnClickListeners() {

        binding.FAB.setOnClickListener {
            startActivity(Intent(this@ChatListActivity, AddNewUser::class.java))
        }
        binding.editButton.setOnClickListener {
            startActivity(Intent(this@ChatListActivity, CurrentUserImage::class.java))
        }
        binding.layout.setOnClickListener {
            startActivity(Intent(this@ChatListActivity, CurrentUserImage::class.java))
        }


    }

}