package com.codecue.fakechatmessengers.activities.FakeChatActivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codecue.fakechatmessengers.Adapters.ChatsAdapter
import com.codecue.fakechatmessengers.Adapters.StoriesAdapter
import com.codecue.fakechatmessengers.databinding.ActivityChatListBinding

class ChatListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setStoriesRecyclerView()
        setChatsRecyclerView()
    }

    private fun setStoriesRecyclerView() {
        binding.storiesRecyclerView.adapter = StoriesAdapter(this)
        binding.storiesRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

    }

    private fun setChatsRecyclerView() {
        binding.chatRecyclerView.adapter = ChatsAdapter(this)
        binding.chatRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }
}