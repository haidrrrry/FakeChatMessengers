package com.codecue.fakechatmessengers.activities.FakeChatActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codecue.fakechatmessengers.Adapters.MessagesAdapter
import com.codecue.fakechatmessengers.R
import com.codecue.fakechatmessengers.databinding.ActivityChatListBinding
import com.codecue.fakechatmessengers.databinding.ActivityChatScreenBinding

class ChatScreen : AppCompatActivity() {

    private lateinit var binding: ActivityChatScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListeners()
        setMessagesRecyclerView()
    }

    private fun setMessagesRecyclerView() {
        binding.messagesRecyclerView.adapter = MessagesAdapter(this)
        binding.messagesRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun setOnClickListeners() {

        binding.backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}