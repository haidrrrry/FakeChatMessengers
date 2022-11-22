package com.codecue.fakechatmessengers.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.codecue.fakechatmessengers.activities.FakeChatActivities.ChatListActivity
import com.codecue.fakechatmessengers.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListners()

    }

    private fun setOnClickListners() {
        binding.fakechathome.setOnClickListener{
            val i=Intent(this,ChatListActivity::class.java)
            startActivity(i)
        }
        binding.contactushome.setOnClickListener{
            Toast.makeText(this, "Click on Contact Us!!", Toast.LENGTH_LONG).show()
        }
        binding.policyprivacyHome.setOnClickListener{
            Toast.makeText(this, "Click on Policy Privacy Us!!", Toast.LENGTH_LONG).show()
        }
        binding.Sharebtnlinearlayout.setOnClickListener{
            Toast.makeText(this, "Click on  Share Btn", Toast.LENGTH_LONG).show()
        }
        binding.getpremiumaccessBtn.setOnClickListener{
            Toast.makeText(this, "Check Premium Version", Toast.LENGTH_LONG).show()
        }
    }
}