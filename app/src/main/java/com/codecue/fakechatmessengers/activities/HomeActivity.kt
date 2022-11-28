package com.codecue.fakechatmessengers.activities

import android.app.ProgressDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codecue.fakechatmessengers.BuildConfig
import com.codecue.fakechatmessengers.activities.FakeChatActivities.ChatListActivity
import com.codecue.fakechatmessengers.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    var progressDialog: ProgressDialog? = null
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



            try {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://codecue.solutions/")
                )
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {

                // youtube is not installed.Will be opened in other available apps
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://codecue.solutions/")
                )
                startActivity(i)
            }
        }
        binding.policyprivacyHome.setOnClickListener{
            try {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://pages.flycricket.io/prank-chat/privacy.html")
                )
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {

                // youtube is not installed.Will be opened in other available apps
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://pages.flycricket.io/prank-chat/privacy.html")
                )
                startActivity(i)
            }
        }
        binding.Sharebtnlinearlayout.setOnClickListener{
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
                var shareMessage = "\nLet me recommend you this application\n\n"
                shareMessage =
                    """
                ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}
                
                
                """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(shareIntent, "choose one"))
            } catch (e: Exception) {
                //e.toString();
            }
        }
        binding.getpremiumaccessBtn.setOnClickListener{
            Toast.makeText(this, "Check Premium Version", Toast.LENGTH_LONG).show()
        }
        binding.instagrambtn.setOnClickListener {

            val uri = Uri.parse("https://www.instagram.com/codecue_/")
            val likeIng = Intent(Intent.ACTION_VIEW, uri)
            likeIng.setPackage("com.instagram.android")
            try {
                startActivity(likeIng)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/codecue_/")
                    )
                )
            }
        }
        binding.youtubebtn.setOnClickListener {
            try {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/@codecue217")
                )
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {

                // youtube is not installed.Will be opened in other available apps
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/@codecue217")
                )
                startActivity(i)
            }
        }
        binding.linkedbtn.setOnClickListener {

            try {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/in/khanzada-saleem-khan-2501b8123")
                )
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {

                // youtube is not installed.Will be opened in other available apps
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/in/khanzada-saleem-khan-2501b8123")
                )
                startActivity(i)
            }
        }
    }
}